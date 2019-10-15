import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { MdcSnackbar } from '@angular-mdc/web';
import { TranslateService } from '@ngx-translate/core';

import { RegistreService } from '../registre/registre.service';
import { ScreenSizeService, ScreenSizeChangeEvent } from '../../shared/screen-size.service';

@Component( {
    template: `
<div mdcBody1 [ngClass]="{'formContentDesktop centered': !mobileScreen, 'formContentMobile': mobileScreen}">
    <div mdcHeadline5>{{'create.titol'|translate}}</div>
    <br/>
    <form [formGroup]="formGroup">
        <mdc-form-field fluid>
            <mdc-text-field
				label="{{'create.field.nom'|translate}}"
				outlined
				maxlength="100"
				formControlName="nom"
				autocomplete="off"></mdc-text-field>
			<mdc-helper-text validation>{{getErrorMessage('nom')}}</mdc-helper-text>
        </mdc-form-field>
        <mdc-form-field fluid>
            <mdc-text-field
				label="{{'create.field.correu'|translate}}"
				outlined
				formControlName="email"
				autocomplete="off"></mdc-text-field>
           <mdc-helper-text validation>{{getErrorMessage('email')}}</mdc-helper-text>
        </mdc-form-field>        
        <br/>
		<button (click)="onCreateButtonClick()" style="display:none"></button>
        <div style="display: flex; justify-content: space-between">  
            <button mdc-button (click)="onCancelButtonClick()" style="text-transform: none">{{'create.button.cancel'|translate}}</button>          
            <button mdc-button primary (click)="onCreateButtonClick()">{{'create.button.crear'|translate}}</button>
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
export class CreateComponent {

	formGroup: FormGroup = this.formBuilder.group({
		nom: ['', Validators.required],
		email: ['', [Validators.required, Validators.email]]
	});
    mobileScreen: boolean;

	onCancelButtonClick() {
		this.router.navigate( ['login'] );
	}

	onCreateButtonClick() {
		this.formGroup.updateValueAndValidity();
		if (this.formGroup.valid) {
			this.registreService.create(this.formGroup).subscribe(( response: any ) => {
				this.showSnack('create.snack.created.ok');
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
			} );
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
		private snackbar: MdcSnackbar,
		private formBuilder: FormBuilder,
		private translate: TranslateService,
		private screenSizeService: ScreenSizeService ) {
		this.mobileScreen = this.screenSizeService.isMobile();
		this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: ScreenSizeChangeEvent ) => {
			this.mobileScreen = event.mobile
		} );
	}

}