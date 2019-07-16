import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../../shared/auth/auth.service';
import { AuthResponse } from '../../shared/auth/auth-response';

@Component( {
    template: `
<div id="mant-header" mdcBody1 mdcElevation="5" class="centered" style="width: 400px; padding: 2em">
    <div mdcHeadline3>Cecocloud</div>
    <form (submit)="onSubmit($event)">
        <mdc-form-field fluid>
            <mdc-text-field label="Usuari" [valid]="valid" (input)="onUserFieldInput($event)"></mdc-text-field>
            <!--mdc-helper-text validation>
                <span>Usuari o contrasenya incorrectes</span>
            </mdc-helper-text-->
        </mdc-form-field>
        <br/>
        <mdc-form-field fluid>
            <mdc-text-field label="Contrasenya" [valid]="valid" (input)="onPassFieldInput($event)"></mdc-text-field>
            <mdc-helper-text validation>
                <span>Usuari o contrasenya incorrectes</span>
            </mdc-helper-text>
        </mdc-form-field>
        <div style="text-align: right">
            <button mdc-button primary (click)="onEntrarButtonClick($event)">Entrar</button>
        </div>
    </form>
</div>
`,
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

    onSubmit(event) {
        event.preventDefault();
        this.onEntrarButtonClick();
    }

    constructor( private authService: AuthService, private router: Router ) { }

}