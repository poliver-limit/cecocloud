import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { RegistresComercialsService } from './registresComercials.service';

import { ClientsFormComponent } from '../clients/clients-form.component';
import { ProductesFormComponent } from '../productes/productes-form.component';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="registresComercialsService"></bng-form>
`
} )
export class RegistresComercialsFormComponent extends BngFormBaseComponent {

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