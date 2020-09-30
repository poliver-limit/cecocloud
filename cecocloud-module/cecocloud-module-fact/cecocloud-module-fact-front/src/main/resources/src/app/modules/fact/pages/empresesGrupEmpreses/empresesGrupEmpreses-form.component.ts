import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { EmpresesGrupEmpresesService } from './empresesGrupEmpreses.service';
import { BusinessGroupsFormComponent } from '../businessGroups/businessGroups-form.component';
import { EmpresesFactFormComponent } from '../empresesFact/empresesFact-form.component';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="empresesGrupEmpresesService"></bng-form>
`
} )
export class EmpresesGrupEmpresesFormComponent extends BngFormBaseComponent{


    constructor(
		activatedRoute: ActivatedRoute,
        public empresesGrupEmpresesService: EmpresesGrupEmpresesService) {
		super(activatedRoute);
		this.setConfigExternalFormComponents([
            { resourceName: 'grupEmpreses', component: BusinessGroupsFormComponent },
            { resourceName: 'empresa', component: EmpresesFactFormComponent }
		]);
	}

}