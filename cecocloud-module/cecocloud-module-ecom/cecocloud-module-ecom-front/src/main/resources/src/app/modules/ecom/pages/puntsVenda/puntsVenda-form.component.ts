import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { PuntsVendaService } from './puntsVenda.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="puntsVendaService"></bng-form>
`
} )
export class PuntsVendaFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

     constructor(
		activatedRoute: ActivatedRoute,
        public puntsVendaService: PuntsVendaService ) {
			super(activatedRoute);
		}

}