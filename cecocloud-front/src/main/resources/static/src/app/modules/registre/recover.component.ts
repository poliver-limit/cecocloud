import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MdcSnackbar } from '@angular-mdc/web';
import { RegistreService } from '../registre/registre.service';
import { TranslateService } from '@ngx-translate/core';

@Component( {
    template: `
<div mdcBody1 mdcElevation="5" class="centered" style="width: 400px; padding: 2em; background-color: white">
    <div mdcHeadline5>{{'recover.titol'|translate}}</div>
    <br/>
    <br/>
    <form (submit)="onSubmit($event)">
        <mdc-form-field fluid>
            <mdc-text-field label="{{'recover.field.correu'|translate}}" outlined [valid]="valid" (input)="onEmailFieldInput($event)"></mdc-text-field>
            <mdc-helper-text validation>
            <span>{{'recover.msg.recover.error'|translate}}</span>
        </mdc-helper-text>
            </mdc-form-field>
        <br/> 
        <div style="display: flex; justify-content: space-between">
            <button mdc-button (click)="onCancelButtonClick($event)" style="text-transform: none">{{'recover.button.cancel'|translate}}</button>            
            <button mdc-button primary (click)="onRecuperarButtonClick($event)">{{'recover.button.recuperar'|translate}}</button>
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


    onRecuperarButtonClick() {
        this.valid = true;
        this.registreService.contrasenyaRecover(
            this.email).subscribe(
            (response) => {
                this.notify_simple();
                this.router.navigate(['login']);
            },
            err => {
                this.valid = false;
            });
    }

    notify_simple() {
        const snackbarRef = this.snackbar.open(this.translate.instant('recover.notify.recover'));
        snackbarRef.afterDismiss().subscribe(reason => {
            console.log(reason);
        });
    }

    onCancelButtonClick() {
        this.router.navigate( ['login'] )
    }

    onSubmit( event ) {
        event.preventDefault();
       // this.onRecuperarButtonClick();
    }

    constructor( 
        private router: Router ,
        private snackbar: MdcSnackbar,
        private registreService: RegistreService,
        private translate: TranslateService) {

    }

}