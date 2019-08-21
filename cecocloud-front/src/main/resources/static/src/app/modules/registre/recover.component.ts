import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MdcSnackbar } from '@angular-mdc/web';
import { TranslateService } from '@ngx-translate/core';

import { RegistreService } from '../registre/registre.service';
import { ScreenSizeService, ScreenSizeChangeEvent } from '../../shared/screen-size.service';

@Component( {
    template: `
<div mdcBody1 [ngClass]="{'formContentDesktop centered': !mobileScreen, 'formContentMobile': mobileScreen}">
    <div mdcHeadline5>{{'recover.titol'|translate}}</div>
    <br/>
    <form (submit)="onSubmit($event)">
        <mdc-form-field fluid>
            <mdc-text-field label="{{'recover.field.correu'|translate}}" outlined [valid]="valid" (input)="onEmailFieldInput($event)"></mdc-text-field>
            <mdc-helper-text validation>
            <span>{{'recover.msg.recover.error'|translate}}</span>
        </mdc-helper-text>
            </mdc-form-field>
        <br/> 
        <div style="display: flex; justify-content: space-between">
            <button mdc-button (click)="onCancelButtonClick($event)" style="text-transform: none">{{'recover.button.cancel'|translate}}</button>            
            <button mdc-button primary (click)="onRecuperarButtonClick($event)">{{'recover.button.recuperar'|translate}}</button>
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
export class RecoverComponent {

    private email: string;
    private valid: boolean = true;
    private mobileScreen: boolean;

    onEmailFieldInput( value ) {
        this.email = value;
    }

    onRecuperarButtonClick() {
        this.valid = true;
        this.registreService.contrasenyaRecover(
            this.email ).subscribe(( response ) => {
                this.notify_simple();
                this.router.navigate( ['login'] );
            }, err => {
                this.valid = false;
            } );
    }

    notify_simple() {
        const snackbarRef = this.snackbar.open( this.translate.instant( 'recover.notify.recover' ) );
        snackbarRef.afterDismiss().subscribe( reason => {
            console.log( reason );
        } );
    }

    onCancelButtonClick() {
        this.router.navigate( ['login'] )
    }

    onSubmit( event ) {
        event.preventDefault();
    }

    constructor(
        private router: Router,
        private snackbar: MdcSnackbar,
        private registreService: RegistreService,
        private translate: TranslateService,
        private screenSizeService: ScreenSizeService ) {
        this.mobileScreen = this.screenSizeService.isMobile();
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: ScreenSizeChangeEvent ) => {
            this.mobileScreen = event.mobile
        } );
    }

}