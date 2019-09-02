import { Directive, ElementRef, Injector } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MdcSnackbar } from '@angular-mdc/web';
import { TranslateService } from '@ngx-translate/core';
import { Resource } from 'angular4-hal';

import { DatagridComponent } from './datagrid.component';

@Directive( {
    selector: '[datagrid-mant]'
} )
export class DatagridMantenimentDirective {

    private http: HttpClient;
    private router: Router;
    private translate: TranslateService;
    private snackbar: MdcSnackbar;

    onDatagridActionCreate( params: any ) {
        let targetRoute = this.getTargetRoute(
            params.resourceName,
            'create' );
        this.navigateWithParent( targetRoute, params.parentPk );
    }
    onDatagridActionDelete( params: any ) {
        let resourceName = params.resource.name;
        let confirmMessageTranslated;
        if (params.selectedRows && params.selectedRows.length > 0) {
            let rowData = params.selectedRows[0];
            let rowDescription = ( params.resource.descriptionField ) ? rowData[params.resource.descriptionField] : '[id:' + rowData.id + ']';
            confirmMessageTranslated = this.translateKey(
                'component.datagrid.manteniment.delete.single.confirm',
                { description: resourceName + ' ' + rowDescription } );
        }
        if ( confirmMessageTranslated && confirm( confirmMessageTranslated ) ) {
            let rowData = params.selectedRows[0];
            this.getResourceDataWithLinks( rowData ).subscribe( dataWithLinks => {
                let linkSelfHref = dataWithLinks._links.self.href;
                this.http.delete( dataWithLinks._links.self.href/*, { params: params.pk }*/ ).subscribe(( resource: Resource ) => {
                    this.showMessage(
                        this.translateKey( 'component.datagrid.manteniment.deleted' ),
                        false );
                    this.datagrid.refreshInternal();
                } );
            } );
        }
    }

    showMessage( message: string, error: boolean ) {
        const snackbarRef = this.snackbar.open(
            message,
            this.translateKey( 'component.datagrid.manteniment.button.close' ), {} );
    }

    navigateWithParent( targetRoute: string, parent: any, removeId?: boolean ) {
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

    getTargetRoute( resourceName, action, id?) {
        let currentRoute = this.router.url;
        if ( currentRoute.indexOf( '?' ) !== -1 ) {
            currentRoute = currentRoute.substring( 0, currentRoute.indexOf( '?' ) );
        }
        let targetRoute = currentRoute;
        targetRoute += ( id ) ? '/' + id : '';
        targetRoute += '/' + action;
        return targetRoute;
    }

    getResourceDataWithLinks( data: any ): Observable<any> {
        return new Observable(( observer ) => {
            if ( data._links ) {
                observer.next( data );
                observer.complete();
            } else {
                let getParams = this.datagrid.restapiService.generateGetParamsWithParent( data.id );
                this.datagrid.restapiService.get( getParams ).subscribe(( resource: Resource ) => {
                    observer.next( Object.assign( data, { _links: resource._links } ) );
                    observer.complete();
                } );
            }
        } );
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
        datagrid.headerActionCreate.subscribe( params => this.onDatagridActionCreate( params ) );
        datagrid.headerActionDelete.subscribe( params => this.onDatagridActionDelete( params ) );
        datagrid.mantenimentConfig();
        this.http = <HttpClient>this.injectorObj.get( HttpClient );
        this.router = <Router>this.injectorObj.get( Router );
        this.snackbar = <MdcSnackbar>this.injectorObj.get( MdcSnackbar );
        this.translate = <TranslateService>this.injectorObj.get( TranslateService );
    }

}
