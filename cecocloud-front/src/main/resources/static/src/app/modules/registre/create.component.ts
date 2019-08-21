import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MdcSnackbar } from '@angular-mdc/web';
import { TranslateService } from '@ngx-translate/core';

import { RegistreService } from '../registre/registre.service';
import { ScreenSizeService, ScreenSizeChangeEvent } from '../../shared/screen-size.service';

@Component( {
    template: `
<div mdcBody1 [ngClass]="{'formContentDesktop centered': !mobileScreen, 'formContentMobile': mobileScreen}">
    <div mdcHeadline5>{{'create.titol'|translate}}</div>
    <br/>
    <form (submit)="onSubmit($event)">
        <mdc-form-field fluid>
            <mdc-text-field label="{{'create.field.nom'|translate}}" outlined [valid]="valid" (input)="onNomFieldInput($event)"></mdc-text-field>
        </mdc-form-field>
        <br/>
        <mdc-form-field fluid>
            <mdc-text-field label="{{'create.field.correu'|translate}}" outlined [valid]="valid" (input)="onEmailFieldInput($event)"></mdc-text-field>
            <mdc-helper-text validation>
                <span>{{'create.msg.create.error'|translate}}</span>
            </mdc-helper-text>
        </mdc-form-field>        
        <br/>
        <div style="display: flex; justify-content: space-between">  
            <button mdc-button (click)="onCancelButtonClick($event)" style="text-transform: none">{{'create.button.cancel'|translate}}</button>          
            <button mdc-button primary (click)="onCrearButtonClick($event)">{{'create.button.crear'|translate}}</button>
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
export class CreateComponent {

    private nom: string;
    private email: string;
    private codi: string;
    private valid: boolean = true;
    private mobileScreen: boolean;

    onNomFieldInput( value ) {
        this.nom = value;
    }
    onEmailFieldInput( value ) {
        this.email = value;
        this.codi = value;
    }

    onCrearButtonClick() {
        this.valid = true;
        this.registreService.create(
            this.codi,
            this.email,
            this.nom ).subscribe(( response ) => {
                this.notify_simple();
                this.router.navigate( ['login'] );
            }, err => {
                this.valid = false;
            } );
    }

    notify_simple() {
        const snackbarRef = this.snackbar.open( this.translate.instant( 'create.notify.create' ) );
        snackbarRef.afterDismiss().subscribe( reason => {
        } );
    }

    onCancelButtonClick() {
        this.router.navigate( ['login'] );
    }

    onSubmit( event ) {
        event.preventDefault();
    }

    constructor(
        private registreService: RegistreService,
        private router: Router,
        private snackbar: MdcSnackbar,
        private translate: TranslateService,
        private screenSizeService: ScreenSizeService ) {
        this.mobileScreen = this.screenSizeService.isMobile();
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: ScreenSizeChangeEvent ) => {
            this.mobileScreen = event.mobile
        } );
    }

}