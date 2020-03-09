import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { RegistresComercialsService } from './registresComercials.service';

import { ClientsFormComponent } from '../clients/clients-form.component';
import { ProductesFormComponent } from '../productes/productes-form.component';

import { FormGroup } from '@angular/forms';

import { descriptionNotEmptyValidator } from './description-not-empty-validator';

@Component( {
	templateUrl: 'registresComercials-form.html'
} )

export class RegistresComercialsFormComponent extends BngFormBaseComponent {
	
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