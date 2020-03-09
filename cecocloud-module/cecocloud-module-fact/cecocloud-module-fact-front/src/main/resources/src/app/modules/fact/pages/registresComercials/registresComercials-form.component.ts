import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent, BngFormErrorMessages } from 'base-angular';
import { RegistresComercialsService } from './registresComercials.service';
import { ClientsFormComponent } from '../clients/clients-form.component';
import { ProductesFormComponent } from '../productes/productes-form.component';
import { FormGroup } from '@angular/forms';
import { descriptionNotEmptyValidator } from './description-not-empty-validator';

@Component( {
	template: `<bng-form
  			bng-form-mant
  			[config]="formConfig"
  			[restapiService]="registresComercialsService"  
  			(formGroupChange)="onFormGroupChange($event)"
  			[errorMessages]="errorMessages"
			>`
} )

export class RegistresComercialsFormComponent extends BngFormBaseComponent {
	
	errorMessages: BngFormErrorMessages = {
		descriptionNotEmpty: {
		messageKey: 'resource.registreComercial.error.descriptionEmpty'
		}
	}
	
	onFormGroupChange(formGroup: FormGroup) {		
		formGroup.setValidators(descriptionNotEmptyValidator('mitja','descripcioMitja'));
	}
	
	formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public registresComercialsService: RegistresComercialsService ) { 
			super(activatedRoute);		
			this.setConfigExternalFormComponents([
				{ resourceName: 'client', component: ClientsFormComponent },
				{ resourceName: 'producte', component: ProductesFormComponent }
			])
		}
}