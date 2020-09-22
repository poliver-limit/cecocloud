import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { BusinessGroupsService } from './businessGroups.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="businessGroupsService"></bng-form>
`
} )
export class BusinessGroupsFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public businessGroupsService: BusinessGroupsService ) {
			super(activatedRoute);
		}
}