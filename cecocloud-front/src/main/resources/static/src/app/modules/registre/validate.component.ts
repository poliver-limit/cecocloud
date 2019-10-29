import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { MdcSnackbar } from '@angular-mdc/web';
import { BngAuthService, BngScreenSizeService, BngScreenSizeChangeEvent } from 'base-angular';

import { RegistreService } from '../registre/registre.service';

@Component( {
    template: `
<div mdcBody1 [ngClass]="{'formContentDesktop centered': !mobileScreen, 'formContentMobile': mobileScreen}">
    <div mdcHeadline5>{{(tokenPayload.aud=='validation')?('validate.titol.validar'|translate):('validate.titol.recuperarContrasenya'|translate)}}</div>
    <form [formGroup]="formGroup">
		<p>{{tokenPayload.name}} &lt;{{tokenPayload.sub}}&gt;</p>
		<ng-container *ngIf="!tokenExpired">
	        <mdc-form-field fluid>
				<mdc-text-field
					type="password"
					label="{{'validate.field.contrasenya'|translate}}"
					outlined
					formControlName="contrasenya"
					autocomplete="off"></mdc-text-field>    
					<mdc-helper-text validation>{{getErrorMessage('contrasenya')}}</mdc-helper-text>       
	        </mdc-form-field>
	        <mdc-form-field fluid>
	            <mdc-text-field
					type="password"
					label="{{'validate.field.contrasenya'|translate}}"
					outlined
					formControlName="repeticio"
					autocomplete="off"></mdc-text-field>    
					<mdc-helper-text validation>{{getErrorMessage('repeticio')}}</mdc-helper-text>      
	        </mdc-form-field>
	        <br/>
			<button (click)="onValidateButtonClick()" style="display:none"></button>
		</ng-container>
		<ng-container *ngIf="tokenExpired">
			<br/>
			<div mdcHeadline5 [mdcElevation]="6" style="padding:1em;color:#d8000c;background-color: #ffbaba; text-align: center">{{'validate.link.expired'|translate}}</div>
			<br/>
		</ng-container>
        <div style="display: flex; justify-content: space-between">
        	<button mdc-button (click)="onCancelButtonClick()" style="text-transform: none">{{'validate.button.cancel'|translate}}</button>
            <button *ngIf="!tokenExpired" mdc-button primary (click)="onValidateButtonClick()">{{'validate.button.validate'|translate}}</button>
        </div>
    </form>
</div>
`,
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
export class ValidateComponent {

	token: string;
	tokenPayload: any;
	tokenExpired: boolean;
	formGroup: FormGroup = this.formBuilder.group({
		contrasenya: ['', Validators.required],
		repeticio: ['', [Validators.required]]
	});
	mobileScreen: boolean;

	onCancelButtonClick() {
		this.router.navigate( ['login'] )
	}

	onValidateButtonClick() {
		this.formGroup.updateValueAndValidity();
		if (this.formGroup.valid) {
			this.registreService.validate( this.token, this.formGroup ).subscribe(( response: any ) => {
				this.showSnack('validate.snack.validated.ok');
				this.router.navigate( ['login'] );
			}, (error: Error) => {
				let processed = false;
				if (error instanceof HttpErrorResponse) {
					if ((<HttpErrorResponse>error).error.errors) {
						(<HttpErrorResponse>error).error.errors.forEach((fieldError: any) => {
							let fieldName: string = fieldError.field;
							let errorCode: string = fieldError.code;
							let errors = {};
							errors[errorCode] = true;
							this.formGroup.controls[fieldName].setErrors(errors);
						})
						processed = true;
					}
				}
				if (!processed) {
					throw error;
				}
	        });
		}
	}

	showSnack(message: string) {
		const snackbarRef = this.snackbar.open(
            this.translate.instant(message),
            this.translateKey( 'component.restapi.form.manteniment.button.close' ), {
            } );
		snackbarRef.afterDismiss().subscribe( reason => {
		} );
	}
	
	getErrorMessage(fieldName: string): string {
		if (this.formGroup.get(fieldName).errors) {
			var errorCode = Object.keys(this.formGroup.get(fieldName).errors)[0];
			if (errorCode) {
				return this.translateKey(
					'error.validation.constraint.' + errorCode,
					undefined,
					this.translate.instant('error.validation.unknown'));
			}
		}
	}

	translateKey(key: string, params?: any, defaultValue?: string) {
		let translatedKey = this.translate.instant(key, params);
		if (defaultValue) {
			return (translatedKey !== key) ? translatedKey : defaultValue;
		} else {
			return translatedKey;
		}
	}

	constructor(
		private registreService: RegistreService,
		private router: Router,
		private activatedRoute: ActivatedRoute,
		private snackbar: MdcSnackbar,
		private formBuilder: FormBuilder,
		authService: BngAuthService,
		private translate: TranslateService,
		private screenSizeService: BngScreenSizeService ) {
		this.activatedRoute.params.subscribe( params => {
			this.token = params['token'];
			this.tokenPayload = authService.tokenToObject(this.token);
			this.tokenExpired = Date.now() > this.tokenPayload.exp * 1000;
		} );
		this.mobileScreen = this.screenSizeService.isMobile();
		this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: BngScreenSizeChangeEvent ) => {
			this.mobileScreen = event.mobile
		} );
	}

}