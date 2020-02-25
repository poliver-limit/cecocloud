import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { TipusAdrecesService } from './tipusAdreces.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusAdrecesService"></bng-form>
`
} )
export class TipusAdrecesFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public tipusAdrecesService: TipusAdrecesService ) {
			super(activatedRoute);
		}
}