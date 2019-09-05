import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { MdcSnackbar } from '@angular-mdc/web';

import { RegistreService } from '../registre/registre.service';
import { ScreenSizeService, ScreenSizeChangeEvent } from '../../shared/screen-size.service';

@Component( {
    template: `
<div mdcBody1 [ngClass]="{'formContentDesktop centered': !mobileScreen, 'formContentMobile': mobileScreen}">
    <div mdcHeadline5>{{(tokenPayload.aud=='validation')?('validate.titol.validar'|translate):('validate.titol.recuperarContrasenya'|translate)}}</div>
    <form (submit)="onSubmit($event)">
        <p>{{'validate.label.nom'|translate}} : {{tokenPayload.name}}</p>
        <p>{{'validate.label.usuari'|translate}} : {{tokenPayload.sub}}</p>
        <mdc-form-field fluid>
			<mdc-text-field type="password" label="{{'validate.field.contrasenya'|translate}}" outlined [valid]="valid" (input)="onContrasenyaFieldInput($event)"></mdc-text-field>            
        </mdc-form-field>
        <br/>
        <mdc-form-field fluid>
            <mdc-text-field type="password" label="{{'validate.field.repContrasenya'|translate}}" outlined [valid]="valid" (input)="onRepContrasenyaFieldInput($event)"></mdc-text-field>            
            <mdc-helper-text validation>
                <span>{{'validate.msg.validate.error'|translate}}</span>
            </mdc-helper-text>
        </mdc-form-field>
        <br/>
        <div style="display: flex; justify-content: space-between">
        <button mdc-button (click)="onCancelButtonClick()" style="text-transform: none">{{'validate.button.cancel'|translate}}</button>
            <button mdc-button primary (click)="onValidarButtonClick()">{{'validate.button.validate'|translate}}</button>
        </div>
    </form>
</div>
`,
    styles: [`
.formContentDesktop {
    padding: 2em;
    background-color: white;
    width: 450px;
    border: 1px solid #dadce0;
    border-radius: 8px;
}
.formContentMobile {
    padding: 2em;
    background-color: white;
}
.formTitle {
    text-align: center;
}
`]
} )
export class ValidateComponent {

    token: string;
    tokenPayload: any;
    contrasenya: string;
    contrasenya2: string;
    valid: boolean = true;
    mobileScreen: boolean;

    onContrasenyaFieldInput( value ) {
        this.contrasenya = value;
    }

    onRepContrasenyaFieldInput( value ) {
        this.contrasenya2 = value;
    }

    onValidarButtonClick() {
        this.valid = true;
        this.registreService.validate( this.contrasenya, this.contrasenya2, this.token ).subscribe(
            ( response ) => {
                this.notifiy();
                this.router.navigate( ['login'] );
            },
            ( error ) => {
                this.valid = false;
            } );
    }

    notifiy() {
        const snackbarRef = this.snackbar.open( this.translate.instant( 'validate.notify.validate' ) );
        snackbarRef.afterDismiss().subscribe( reason => {
        } );
    }

    onCancelButtonClick() {
        this.router.navigate( ['login'] )
    }

    onSubmit( event ) {
        event.preventDefault();
    }

    constructor(
        private registreService: RegistreService,
        private router: Router,
        private activatedRoute: ActivatedRoute,
        private snackbar: MdcSnackbar,
        private translate: TranslateService,
        private screenSizeService: ScreenSizeService ) {
        this.activatedRoute.params.subscribe( params => {
            this.token = params['token'];
            let base64Url = this.token.split( '.' )[1];
            let base64 = base64Url.replace( /-/g, '+' ).replace( /_/g, '/' );
            this.tokenPayload = JSON.parse( atob( base64 ) );
        } );
        this.mobileScreen = this.screenSizeService.isMobile();
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: ScreenSizeChangeEvent ) => {
            this.mobileScreen = event.mobile
        } );
    }

}