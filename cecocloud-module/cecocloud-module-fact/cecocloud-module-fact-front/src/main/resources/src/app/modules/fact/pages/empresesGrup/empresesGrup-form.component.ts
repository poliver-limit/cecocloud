import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { EmpresesGrupService } from './empresesGrup.service';
import { GroupsFormComponent } from '../groups/groups-form.component';
import { EmpresesFactFormComponent } from '../empresesFact/empresesFact-form.component';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="empresesGrupService"></bng-form>
`
} )
export class EmpresesGrupFormComponent extends BngFormBaseComponent{


    constructor(
		activatedRoute: ActivatedRoute,
        public empresesGrupService: EmpresesGrupService) {
		super(activatedRoute);
		this.setConfigExternalFormComponents([
            { resourceName: 'grup', component: GroupsFormComponent },
            { resourceName: 'empresa', component: EmpresesFactFormComponent }
		]);
	}

}