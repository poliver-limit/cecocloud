import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { RappelsService } from './rappels.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="rappelsService"></bng-form>
`
} )
export class RappelsFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

     constructor(
		activatedRoute: ActivatedRoute,
        public rappelsService: RappelsService ) {
			super(activatedRoute);
		}
}