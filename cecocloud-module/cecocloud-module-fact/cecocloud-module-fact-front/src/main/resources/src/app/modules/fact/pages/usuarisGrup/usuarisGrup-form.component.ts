import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { UsuarisGrupService } from './usuarisGrup.service';
import { GroupsFormComponent } from '../groups/groups-form.component';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="usuarisGrupService"></bng-form>
`
} )
export class UsuarisGrupFormComponent extends BngFormBaseComponent{


    constructor(
		activatedRoute: ActivatedRoute,
        public usuarisGrupService: UsuarisGrupService) {
		super(activatedRoute);
		this.setConfigExternalFormComponents([
            { resourceName: 'grup', component: GroupsFormComponent }
		]);
	}

}