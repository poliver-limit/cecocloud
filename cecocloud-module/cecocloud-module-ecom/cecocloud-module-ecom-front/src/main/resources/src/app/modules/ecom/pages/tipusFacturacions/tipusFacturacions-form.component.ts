import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { TipusFacturacionsService } from './tipusFacturacions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusFacturacionsService"></bng-form>
`
} )
export class TipusFacturacionsFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public tipusFacturacionsService: TipusFacturacionsService ) {
			super(activatedRoute);
		}
}