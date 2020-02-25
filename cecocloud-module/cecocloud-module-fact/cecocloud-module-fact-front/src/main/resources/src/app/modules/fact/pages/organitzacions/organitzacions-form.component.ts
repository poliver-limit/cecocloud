import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { OrganitzacionsService } from './organitzacions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="organitzacionsService"></bng-form>
`
} )
export class OrganitzacionsFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public organitzacionsService: OrganitzacionsService ) {
			super(activatedRoute);
		}
}