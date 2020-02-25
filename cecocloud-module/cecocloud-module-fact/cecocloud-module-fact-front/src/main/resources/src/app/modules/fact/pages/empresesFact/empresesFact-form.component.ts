import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { EmpresesFactService } from './empresesFact.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="empresesFactService"></bng-form>
`
} )
export class EmpresesFactFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public empresesFactService: EmpresesFactService ) {
			super(activatedRoute);
		}

}