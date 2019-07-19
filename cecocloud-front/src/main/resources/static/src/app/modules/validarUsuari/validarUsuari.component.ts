import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { AuthService } from '../../shared/auth/auth.service';
import { AuthResponse } from '../../shared/auth/auth-response';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
    template: `
<div id="mant-header" mdcBody1 mdcElevation="5" class="centered" style="width: 400px; padding: 2em">
    <div mdcHeadline5>Validar usuari</div>
    <br/>
    <form (submit)="onSubmit($event)"> 
        <p>Usuari : {{email}}</p>   
        <p>Nom : {{nom}}</p>         
        <br/>
        <br/>
        <mdc-form-field fluid>
            <mdc-text-field label="Contrasenya" outlined [valid]="valid" (input)="onContrasenyaFieldInput($event)"></mdc-text-field>
        </mdc-form-field>
        <br/>
        <mdc-form-field fluid>
            <mdc-text-field label="Repetir contrasenya" outlined [valid]="valid" (input)="onRepContrasenyaFieldInput($event)"></mdc-text-field>
            <mdc-helper-text validation>
                <span>La contrasenya no coincideix</span>
            </mdc-helper-text>
        </mdc-form-field>        
        <br/>
        <div style="display: flex; justify-content: space-between"> 
        <button mdc-button (click)="onCancelButtonClick($event)" style="text-transform: none">Cancel·lar</button>            
            <button mdc-button primary (click)="onContrasenyaButtonClick($event)">Validar</button>
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
export class ValidarUsuariComponent {

    private contrasenya: string;
    private contrasenya2: string;
    email: string;
    nom: string;

    private valid: boolean = true;

    onContrasenyaFieldInput(value) {
        this.contrasenya = value;
    }
    onRepContrasenyaFieldInput(value) {
        this.contrasenya2 = value;
    }

    onContrasenyaButtonClick() {
        this.valid = true;

        if (this.contrasenya != this.contrasenya2) {
            this.valid = false;
        } else {
            this.valid = true;
        }

        this.authService.authenticate(this.contrasenya, null).subscribe(
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
        this.onContrasenyaButtonClick();
    }

    constructor(private authService: AuthService, private router: Router, private route: ActivatedRoute) {
        this.nom = history.state.data['nom'];
        this.email = history.state.data['mail'];
    }

}