import { Directive, Injector } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { MdcSnackbar } from '@angular-mdc/web';
import { TranslateService } from '@ngx-translate/core';

import { DatagridComponent } from './datagrid.component';

@Directive( {
    selector: '[datagrid-mant]'
} )
export class DatagridMantenimentDirective {

    http: HttpClient;
    router: Router;
    translate: TranslateService;
    snackbar: MdcSnackbar;

    onDatagridActionCreate(params: any) {
        let targetRoute = this.getTargetRoute('create' );
        this.navigateWithParent( targetRoute, params.parentPk );
    }

    onDatagridActionDelete(params: any) {
        if (params.selectedRows && params.selectedRows.length > 0) {
			if (params.selectedRows.length == 1) {
				let resourceName = this.translateKey(params.resource.translateKey).toLowerCase();
				let rowData = params.selectedRows[0];
	            let rowDescription = ( params.resource.descriptionField ) ? rowData[params.resource.descriptionField] : '#' + rowData.id;
	        	let confirmMessageTranslated: string = this.translateKey(
	                'component.datagrid.manteniment.delete.single.confirm',
	                {description: resourceName + ' ' + rowDescription});
				if (confirm( confirmMessageTranslated ) ) {
	                this.http.delete( rowData._links.self.href ).subscribe(() => {
	                    this.showMessage(
							this.translateKey('component.datagrid.manteniment.deleted.single'));
	                    this.datagrid.refreshInternal();
	                } );
	        	}
			} else {
				let resourceNamePlural = this.translateKey(params.resource.translateKeyPlural).toLowerCase();
				let confirmMessageTranslated = this.translateKey(
	                'component.datagrid.manteniment.delete.multiple.confirm',
	                {count: params.selectedRows.length, description: resourceNamePlural});
				if (confirm( confirmMessageTranslated ) ) {
					let baseApiUrl = params.selectedRows[0]._links.base.href;
					if (baseApiUrl.indexOf('{') != -1) {
						baseApiUrl = baseApiUrl.substring(0, baseApiUrl.indexOf('{'));
					}
					baseApiUrl += '/bulk/delete';
					let ids = params.selectedRows.map((resource: any) => {return resource.id})
					let bulkDeleteOperation = {ids: ids};
	                this.http.post( baseApiUrl, bulkDeleteOperation ).subscribe((response: any) => {
						if (response.errorCount == 0) {
		                    this.showMessage(
								this.translateKey(
									'component.datagrid.manteniment.deleted.multiple',
									{totalCount: response.totalCount}));
						} else {
							this.showMessage(
								this.translateKey(
									'component.datagrid.manteniment.deleted.multiple.error',
									{successCount: response.successCount, totalCount: response.totalCount}));
						}
	                    this.datagrid.refreshInternal();
	                } );
	        	}
			}
        }
    }

    showMessage(message: string) {
        this.snackbar.open(
            message,
            this.translateKey( 'component.datagrid.manteniment.button.close' ), {} );
    }

    navigateWithParent(targetRoute: string, parent: any, removeId?: boolean) {
        if ( parent ) {
            if ( removeId ) {
                delete parent['id'];
            }
            delete parent['identificadorCodi'];
            delete parent['empresaCodi'];
            this.router.navigate( [targetRoute], { queryParams: parent } );
        } else {
            this.router.navigate( [targetRoute] );
        }
    }

    getTargetRoute(action: string, id?: any) {
        let currentRoute = this.router.url;
        if ( currentRoute.indexOf( '?' ) !== -1 ) {
            currentRoute = currentRoute.substring( 0, currentRoute.indexOf( '?' ) );
        }
        let targetRoute = currentRoute;
        targetRoute += ( id ) ? '/' + id : '';
        targetRoute += '/' + action;
        return targetRoute;
    }

    translateKey( key: string, params?: any, defaultValue?: string ) {
        let translatedKey = this.translate.instant( key, params );
        if ( defaultValue ) {
            return ( translatedKey !== key ) ? translatedKey : defaultValue;
        } else {
            return translatedKey;
        }
    }

    constructor(
        private datagrid: DatagridComponent,
        private injectorObj: Injector ) {
        datagrid.headerActionCreate.subscribe((params: any) => this.onDatagridActionCreate(params));
        datagrid.headerActionDelete.subscribe((params: any) => this.onDatagridActionDelete(params));
        datagrid.mantenimentConfig();
        this.http = <HttpClient>this.injectorObj.get( HttpClient );
        this.router = <Router>this.injectorObj.get( Router );
        this.snackbar = <MdcSnackbar>this.injectorObj.get( MdcSnackbar );
        this.translate = <TranslateService>this.injectorObj.get( TranslateService );
    }

}
