import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    template: `
<div mdcBody1 mdcElevation="5" class="centered" style="width: 400px; padding: 2em; background-color: white">
    <div mdcHeadline5>Crear nou usuari.</div>
    <br/>
    <form (submit)="onSubmit($event)">
        <mdc-form-field fluid>
            <mdc-text-field label="Nom" outlined [valid]="valid" (input)="onNomFieldInput($event)"></mdc-text-field>
        </mdc-form-field>
        <br/>
        <mdc-form-field fluid>
            <mdc-text-field label="Correu-e" outlined [valid]="valid" (input)="onEmailFieldInput($event)"></mdc-text-field>
            <mdc-helper-text validation>
                <span>L'usuari o el correu electrónic ja existeix.</span>
            </mdc-helper-text>
        </mdc-form-field>        
        <br/>
        <div style="display: flex; justify-content: space-between">  
            <button mdc-button (click)="onCancelButtonClick($event)" style="text-transform: none">Cancel·lar</button>          
            <button mdc-button primary (click)="onCrearButtonClick($event)">Crear</button>
        </div>
    </form>
</div>
`,
    styles: [`
.centered {
    margin: 10% auto;
}
      `]
})
export class CreateComponent {

    private nom: string;
    private email: string;

    private valid: boolean = true;

    onNomFieldInput(value) {
        this.nom = value;
    }
    onEmailFieldInput(value) {
        this.email = value;
    }

    onCrearButtonClick() {
        this.valid = true;
    }

    onCancelButtonClick() {
        this.router.navigate(['validarUsuari'], { state: { data: { nom: this.nom, 'mail': this.email } } });
    }

    onSubmit(event) {
        event.preventDefault();
        this.onCrearButtonClick();
    }

    constructor(private router: Router) { }

}