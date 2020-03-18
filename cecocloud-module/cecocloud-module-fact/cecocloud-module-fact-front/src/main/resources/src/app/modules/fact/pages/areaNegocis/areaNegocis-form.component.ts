import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { AreaNegocisService } from './areaNegocis.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="areaNegocisService"></bng-form>
`
} )
export class AreaNegocisFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public areaNegocisService: AreaNegocisService ) {
			super(activatedRoute);
		}

}