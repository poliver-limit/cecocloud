import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { EmpresesEcomService } from './empresesEcom.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="empresesEcomService"></bng-form>
`
} )
export class EmpresesEcomFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public empresesEcomService: EmpresesEcomService ) {
			super(activatedRoute);
		}

}