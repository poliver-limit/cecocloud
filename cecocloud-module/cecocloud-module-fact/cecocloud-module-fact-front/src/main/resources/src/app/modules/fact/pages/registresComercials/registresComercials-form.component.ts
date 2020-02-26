import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { RegistresComercialsService } from './registresComercials.service';

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
		}
}