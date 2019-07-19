import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';

import { AuthService } from '../../shared/auth/auth.service';
import { AuthResponse } from '../../shared/auth/auth-response';

@Component( {
    template: `
<div mdcBody1 mdcElevation="5" class="centered" style="width: 400px; padding: 2em; background-color: white;">
    <div mdcHeadline3>{{'app.titol'|translate}}</div>
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
        <button mdc-button (click)="onPasswordRecoveryButtonClick($event)" style="text-transform: none">{{'login.msg.contrasenya.recover'|translate}}</button>
        <br/>
        <div style="display: flex; justify-content: space-between">
            <button mdc-button (click)="onCreateButtonClick($event)" style="text-transform: none">{{'login.msg.usuari.create'|translate}}</button>
            <button mdc-button primary (click)="onEntrarButtonClick($event)">{{'login.button.entrar'|translate}}</button>
        </div>
    </form>
</div>`,
    styles: [`
.centered {
    position: absolute;
    left: 50%;
    top: 50%;
    -webkit-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
}
        `]
} )
export class LoginComponent {

    private user: string;
    private pass: string;

    private valid: boolean = true;

    onUserFieldInput( value ) {
        this.user = value;
    }
    onPassFieldInput( value ) {
        this.pass = value;
    }

    onEntrarButtonClick() {
        this.valid = true;
        this.authService.authenticate( this.user, this.pass ).subscribe(
            ( response ) => {
                if ( response.error ) {
                    this.valid = false;
                } else {
                    this.router.navigate( ['/'] );
                }
            } );
    }

    onCreateButtonClick() {
        event.preventDefault();
        alert('Funcionalitat pendent de desenvolupar');
    }

    onPasswordRecoveryButtonClick() {
        event.preventDefault();
        alert('Funcionalitat pendent de desenvolupar');
    }

    onSubmit( event ) {
        event.preventDefault();
        this.onEntrarButtonClick();
    }

    constructor( private authService: AuthService, private router: Router ) { }

}