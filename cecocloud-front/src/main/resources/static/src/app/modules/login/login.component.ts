import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BngAuthService, BngScreenSizeService, BngScreenSizeChangeEvent } from '@programari-limit/bang';

@Component( {
    template: `
<div mdcBody1 [ngClass]="{'formContentDesktop centered': !mobileScreen, 'formContentMobile': mobileScreen}">
    <div class="formTitle" mdcHeadline3><mdc-icon style="font-size:40px">cloud_queue</mdc-icon>&nbsp;Cecocloud</div>
    <br/>
    <form (submit)="onSubmit($event)">
        <mdc-form-field fluid>
            <mdc-text-field label="{{'login.field.usuari'|translate}}" outlined [valid]="valid" (input)="onUserFieldInput($event)"></mdc-text-field>
        </mdc-form-field>
        <br/>
        <mdc-form-field fluid>
            <mdc-text-field label="{{'login.field.contrasenya'|translate}}" type="password" outlined [valid]="valid" (input)="onPassFieldInput($event)"></mdc-text-field>
            <mdc-helper-text validation>
                <span>{{'login.msg.login.error'|translate}}</span>
            </mdc-helper-text>
        </mdc-form-field>
        <a mdc-button routerLink="/registre/recover" style="text-transform: none">{{'login.msg.contrasenya.recover'|translate}}</a>
        <br/>
        <div style="display: flex; justify-content: space-between">
            <a mdc-button routerLink="/registre/create" style="text-transform: none">{{'login.msg.usuari.create'|translate}}</a>
            <button mdc-button primary (click)="onEntrarButtonClick()">{{'login.button.entrar'|translate}}</button>
        </div>
    </form>
</div>`,
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
export class LoginComponent {

    user: string;
    pass: string;
    valid: boolean = true;
    mobileScreen: boolean;

    onUserFieldInput( value: string ) {
        this.user = value;
    }
    onPassFieldInput( value: string ) {
        this.pass = value;
    }

    onEntrarButtonClick() {
        this.valid = true;
        this.authService.login( this.user, this.pass ).subscribe(
            ( response ) => {
                if ( response.error ) {
                    this.valid = false;
                } else {
                    this.router.navigate( ['/home'] );
                }
            } );
    }

    onSubmit( event: Event ) {
        event.preventDefault();
        this.onEntrarButtonClick();
    }

    constructor(
        private authService: BngAuthService,
        private router: Router,
        private screenSizeService: BngScreenSizeService ) {
        this.mobileScreen = this.screenSizeService.isMobile();
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: BngScreenSizeChangeEvent ) => {
            this.mobileScreen = event.mobile
        } );
    }

}