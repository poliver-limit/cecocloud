import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { RegimsIvaService } from './regimsIva.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="regimsIvaService"></bng-form>
`
} )
export class RegimsIvaFormComponent extends BngFormBaseComponent {


    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public regimsIvaService: RegimsIvaService ) {
			super(activatedRoute);
		}

}