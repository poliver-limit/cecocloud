import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { ClientsAdresaService } from './clientsAdresa.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="clientsAdresaService"></bng-form>
`
} )
export class ClientsAdresaFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public clientsAdresaService: ClientsAdresaService ) {
			super(activatedRoute);
		}
}