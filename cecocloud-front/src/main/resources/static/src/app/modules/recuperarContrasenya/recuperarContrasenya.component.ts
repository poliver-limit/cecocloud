import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../../shared/auth/auth.service';
import { AuthResponse } from '../../shared/auth/auth-response';

@Component({
    template: `
    <div id="mant-header" mdcBody1 mdcElevation="5" class="centered" style="width: 400px; padding: 2em">
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
})
export class RecuperarContrasenyaComponent {

    private email: string;

    private valid: boolean = true;

    onEmailFieldInput(value) {
        this.email = value;
    }


    onEnviarButtonClick() {
        this.valid = true;
        this.authService.authenticate(this.email, null).subscribe(
            (response) => {
                if (response.error) {
                    this.valid = false;
                } else {
                    this.router.navigate(['/']);
                }
            });
    }

    onCancelButtonClick() {
        this.router.navigate(['login'])
    }

    onSubmit(event) {
        event.preventDefault();
        this.onEnviarButtonClick();
    }

    constructor(private authService: AuthService, private router: Router) {

    }

}