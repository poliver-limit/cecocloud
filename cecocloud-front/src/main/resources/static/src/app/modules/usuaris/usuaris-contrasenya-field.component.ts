import { Component, Input, Injector, Inject, ViewChild, ElementRef, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { MdcDialog, MdcDialogRef, MDC_DIALOG_DATA, MdcSnackbar } from '@angular-mdc/web';

import { RestapiBaseFieldComponent } from '../../shared/restapi-form/restapi-base-field.component';
import { UsuarisService } from './usuaris.service';

@Component( {
    selector: 'usuari-contrasenya',
    template: `
<div>
	<button mdc-button primary (click)="onButtonClick($event)">{{'module.usuaris.canvi.contrasenya.titol'|translate}}</button>
</div>
`, styles: [`
`]
} )
export class UsuarisContrasenyaFieldComponent extends RestapiBaseFieldComponent {

	@Input() usuariId: number;

	onButtonClick(event: Event) {
		event.stopPropagation();
		event.preventDefault();
		const dialog = this.injector.get( MdcDialog );
        /*const dialogRef = */dialog.open( UsuarisContrasenyaDialog, {
            data: {
				usuariId: this.usuariId
            }
        } );
	}

    public setErrors( errors?: any ) {
    }

    getFieldComponent() {
    }

	constructor(
        private injector: Injector,
		translate: TranslateService ) {
		super(translate);
    }

}

@Component( {
    template: `
<mdc-dialog class="default-error-dialog">
    <mdc-dialog-container>
        <mdc-dialog-surface>
            <mdc-dialog-title>{{'module.usuaris.canvi.contrasenya.titol'|translate}}</mdc-dialog-title>
            <mdc-dialog-content>
				<form [formGroup]="formGroup">
					<button (click)="onButtonCanviarClick()" style="display:none"></button>
	                <mat-form-field style="width:100%">
	    				<mat-label>{{'module.usuaris.canvi.contrasenya.field.contrasenya'|translate}}</mat-label>
						<input #inputPassword matInput formControlName="password" type="password" autocomplete="off" required/>
						<mat-error>{{fieldError}}</mat-error>
					</mat-form-field>
					<mat-form-field style="width:100%">
	    				<mat-label>{{'module.usuaris.canvi.contrasenya.field.confirmacio'|translate}}</mat-label>
						<input #inputConfirmation matInput formControlName="confirmation" type="password" autocomplete="off" required/>
						<mat-error>{{fieldError}}</mat-error>
					</mat-form-field>
				</form>
            </mdc-dialog-content>
            <mdc-dialog-actions>
                <button mdcDialogButton mdcDialogAction="close">{{'module.usuaris.canvi.contrasenya.button.cancelar'|translate}}</button>
				<button mdcDialogButton primary (click)="onButtonCanviarClick()">{{'module.usuaris.canvi.contrasenya.button.canviar'|translate}}</button>
            </mdc-dialog-actions>
        </mdc-dialog-surface>
    </mdc-dialog-container>
</mdc-dialog>`
} )
export class UsuarisContrasenyaDialog implements OnInit {

	@ViewChild( 'inputPassword', { static: false } ) passwordField: ElementRef;

	formGroup: FormGroup;
	fieldError: string;

	ngOnInit() {
		this.formGroup = this.formBuilder.group({
			password: [''],
			confirmation: ['']
		});
	}

	onButtonCanviarClick() {
		let password = this.formGroup.get('password').value;
		let confirmation = this.formGroup.get('confirmation').value;
		if (!password && !confirmation) {
			this.passwordField.nativeElement.focus();
			this.fieldError = this.translate.instant('error.validation.contraint.NotNull');
			this.formGroup.get('password').markAsTouched();
			this.formGroup.get('password').setErrors({'error': true});
			this.formGroup.get('confirmation').markAsTouched();
			this.formGroup.get('confirmation').setErrors({'error': true});
		} else {
			if (password == confirmation) {
				let patchUrl = this.usuarisService.getResourceUrl('/' + this.data.usuariId);
				let patchOperation: any = { op: 'replace', path: '/contrasenya', value: password };
				this.usuarisService.getHttpClient().patch(patchUrl, [patchOperation]).subscribe((usuari: any) => {
					this.snackbar.open(
						this.translate.instant('module.usuaris.canvi.contrasenya.ok'),
						this.translate.instant('component.restapi.form.manteniment.button.close'));
					this.dialogRef.close();
				});
			} else {
				this.fieldError = this.translate.instant('module.usuaris.canvi.contrasenya.no.coincideix');
				this.formGroup.get('password').markAsTouched();
				this.formGroup.get('password').setErrors({'error': true});
				this.formGroup.get('confirmation').markAsTouched();
				this.formGroup.get('confirmation').setErrors({'error': true});
			}
		}
	}

    constructor(
		private dialogRef: MdcDialogRef<UsuarisContrasenyaDialog>,
        @Inject( MDC_DIALOG_DATA ) public data: any,
		private formBuilder: FormBuilder,
		private snackbar: MdcSnackbar,
		private translate: TranslateService,
		private usuarisService: UsuarisService) {
        this.data = data;
    }

}