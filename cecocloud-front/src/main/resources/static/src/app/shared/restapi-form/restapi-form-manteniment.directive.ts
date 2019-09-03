import { Directive, ElementRef, Injector } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { MdcSnackbar } from '@angular-mdc/web';

import { RestapiFormComponent } from '../restapi-form/restapi-form.component';

@Directive( {
    selector: '[restapi-form-mant]'
} )
export class RestapiFormMantenimentDirective {

    private id: string;
    private currentRouteUrl: string;
    private router: Router;
    private translate: TranslateService;
    private snackbar: MdcSnackbar;

    onFormActionCancel() {
        this.goToList();
    }
    onFormActionSave() {
        if ( this.restapiForm.isCreacio() ) {
            this.showMessage(
                this.translateKey( 'component.restapi.form.manteniment.created' ),
                false );
        } else {
            this.showMessage(
                this.translateKey( 'component.restapi.form.manteniment.updated' ),
                false );
        }
        this.goToList();
    }
    onFormActionDelete() {
        this.showMessage(
                this.translateKey( 'component.restapi.form.manteniment.deleted' ),
                false );
        this.goToList();
    }

    showMessage( message: string, error: boolean ) {
        const snackbarRef = this.snackbar.open(
            message,
            this.translateKey( 'component.restapi.form.manteniment.button.close' ), {
            } );

    }

    goToList() {
        let index = this.currentRouteUrl.indexOf( '/create' );
        if ( index == -1 ) {
            index = this.currentRouteUrl.indexOf( '/update' );
        }
        this.router.navigate( [this.currentRouteUrl.substring( 0, index )] );
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
        private restapiForm: RestapiFormComponent,
        private injectorObj: Injector ) {
        restapiForm.actionCancel.subscribe(() => this.onFormActionCancel() );
        restapiForm.actionSave.subscribe(() => this.onFormActionSave() );
        restapiForm.actionDelete.subscribe(() => this.onFormActionDelete() );
        this.router = <Router>this.injectorObj.get( Router );
        this.currentRouteUrl = this.router.url;
        this.snackbar = <MdcSnackbar>this.injectorObj.get( MdcSnackbar );
        this.translate = <TranslateService>this.injectorObj.get( TranslateService );
        let activatedRoute = <ActivatedRoute>this.injectorObj.get( ActivatedRoute );
        activatedRoute.params.subscribe(( params ) => {
            if ( params.id ) {
                restapiForm.id = params.id;
            }
        } );
        activatedRoute.queryParams.subscribe(( queryParams ) => {
            let isEmpty = Object.keys( queryParams ).length === 0 && queryParams.constructor === Object;
            if ( !isEmpty ) {
                restapiForm.setParentFromRoute( queryParams );
            }
        } );
    }

}
