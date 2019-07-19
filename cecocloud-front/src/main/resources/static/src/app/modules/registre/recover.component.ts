import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component( {
    template: `
<div mdcBody1 mdcElevation="5" class="centered" style="width: 400px; padding: 2em; background-color: white">
    <div mdcHeadline5>Recuperar contrasenya.</div>
    <br/>
    <br/>
    <form (submit)="onSubmit($event)">
        <mdc-form-field fluid>
            <mdc-text-field label="Correu-e" outlined [valid]="valid" (input)="onEmailFieldInput($event)"></mdc-text-field>
            <mdc-helper-text validation>
            <span>Correu electrónic incorrecte.</span>
        </mdc-helper-text>
            </mdc-form-field>
        <br/> 
        <div style="display: flex; justify-content: space-between">
            <button mdc-button (click)="onCancelButtonClick($event)" style="text-transform: none">Cancel·lar</button>            
            <button mdc-button primary (click)="onEnviarButtonClick($event)">Recuperar</button>
        </div>
    </form>
</div>
`,
    styles: [`
.centered {      
    margin: 10% auto;
}
        `]
} )
export class RecoverComponent {

    private email: string;

    private valid: boolean = true;

    onEmailFieldInput( value ) {
        this.email = value;
    }


    onEnviarButtonClick() {
        this.valid = true;

    }

    onCancelButtonClick() {
        this.router.navigate( ['login'] )
    }

    onSubmit( event ) {
        event.preventDefault();
        this.onEnviarButtonClick();
    }

    constructor( private router: Router ) {

    }

}