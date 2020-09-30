import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { ParametersService } from './parameters.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="parametersService"></bng-form>
`
} )
export class ParametersFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public parametersService: ParametersService ) {
			super(activatedRoute);
		}
}