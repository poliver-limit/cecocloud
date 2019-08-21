import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../../shared/auth/auth.service';
import { AuthResponse } from '../../shared/auth/auth-response';

@Component( {
    template: `
<div mdcBody1 mdcElevation="5" class="centered" style="width: 400px; padding: 2em; background-color: white;">
    <div mdcHeadline3><mdc-icon style="font-size:40px">cloud_queue</mdc-icon> {{'app.titol'|translate}}</div>
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
            <button mdc-button primary (click)="onEntrarButtonClick($event)">{{'login.button.entrar'|translate}}</button>
        </div>
    </form>
</div>`
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
                    this.router.navigate( ['/home'] );
                }
            } );
    }

    onSubmit( event ) {
        event.preventDefault();
        this.onEntrarButtonClick();
    }

    constructor(
        private authService: AuthService,
        private router: Router ) { }

}