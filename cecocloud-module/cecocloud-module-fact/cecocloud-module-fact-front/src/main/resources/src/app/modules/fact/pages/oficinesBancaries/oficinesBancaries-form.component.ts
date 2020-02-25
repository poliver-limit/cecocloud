import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { OficinesBancariesService } from './oficinesBancaries.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="oficinesBancariesService"></bng-form>
`
} )
export class OficinesBancariesFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public oficinesBancariesService: OficinesBancariesService ) {
			super(activatedRoute);
		}
}