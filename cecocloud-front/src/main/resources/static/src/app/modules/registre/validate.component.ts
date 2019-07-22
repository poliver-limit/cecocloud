import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { MdcSnackbar } from '@angular-mdc/web';
import { RegistreService } from '../registre/registre.service';
import { TranslateService } from '@ngx-translate/core';

@Component({
    template: `
<div mdcBody1 mdcElevation="5" class="centered" style="width: 400px; padding: 2em; background-color: white">
    <div mdcHeadline5>{{(tokenPayload.aud=='validation')?('validate.titol.validar'|translate):('validate.titol.recuperarContrasenya'|translate)}}</div>
    <br/>
    <form (submit)="onSubmit($event)"> 
        <p>{{'validate.label.usuari'|translate}} : {{tokenPayload.sub}}</p>   
        <p>{{'validate.label.nom'|translate}} : {{tokenPayload.name}}</p>         
        <br/>
        <br/>
        <mdc-form-field fluid>
            <mdc-text-field type="password" label="{{'validate.field.constrasenya'|translate}}" outlined [valid]="valid" (input)="onContrasenyaFieldInput($event)"></mdc-text-field>
            <mdc-text-field label="{{'validate.field.constrasenya'|translate}}" outlined [valid]="valid" (input)="onContrasenyaFieldInput($event)"></mdc-text-field>
        </mdc-form-field>
        <br/>
        <mdc-form-field fluid>
            <mdc-text-field type="password" label="{{'validate.field.repConstrasenya'|translate}}" outlined [valid]="valid" (input)="onRepContrasenyaFieldInput($event)"></mdc-text-field>
            <mdc-text-field label="{{'validate.field.repConstrasenya'|translate}}" outlined [valid]="valid" (input)="onRepContrasenyaFieldInput($event)"></mdc-text-field>
            <mdc-helper-text validation>
                <span>{{'validate.msg.validate.error'|translate}}</span>
            </mdc-helper-text>
        </mdc-form-field>        
        <br/>
        <div style="display: flex; justify-content: space-between"> 
        <button mdc-button (click)="onCancelButtonClick($event)" style="text-transform: none">{{'validate.button.cancel'|translate}}</button>            
            <button mdc-button primary (click)="onValidarButtonClick($event)">{{'validate.button.validate'|translate}}</button>
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
export class ValidateComponent {

    private token: string;
    private tokenPayload: any;
    private contrasenya: string;
    private contrasenya2: string;

    private valid: boolean = true;



    onContrasenyaFieldInput(value) {
        this.contrasenya = value;
    }
    onRepContrasenyaFieldInput(value) {
        this.contrasenya2 = value;
    }

    onValidarButtonClick() {

        this.valid = true;
        this.registreService.validate(this.contrasenya, this.contrasenya2, this.token).subscribe(
            (response) => {
                this.notify_simple();
                this.router.navigate(['login']);
            },
            (error) => {
                this.valid = false;
            });

    }

    notify_simple() {

        const snackbarRef = this.snackbar.open(this.translate.instant('validate.notify.validate'));
        snackbarRef.afterDismiss().subscribe(reason => {
            console.log(reason);
        });
    }

    onCancelButtonClick() {
        this.router.navigate(['login'])
    }

    onSubmit(event) {
        event.preventDefault();
        this.onValidarButtonClick();
    }

    constructor(
        private registreService: RegistreService,
        private router: Router,
        private activatedRoute: ActivatedRoute,
        private snackbar: MdcSnackbar,
        private translate: TranslateService) {
        this.activatedRoute.params.subscribe(params => {
            this.token = params['token'];
            let base64Url = this.token.split('.')[1];
            let base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
            this.tokenPayload = JSON.parse(atob(base64));
            console.log('>>> tokenPayload', this.tokenPayload)
        });

    }

}