import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { UnitatsControlEstudiService } from './unitatsControlEstudi.service';
import { EmpresesFactFormComponent } from '../empresesFact/empresesFact-form.component';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="unitatsControlEstudiService"></bng-form>
`
} )
export class UnitatsControlEstudiFormComponent extends BngFormBaseComponent{


    constructor(
		activatedRoute: ActivatedRoute,
        public unitatsControlEstudiService: UnitatsControlEstudiService) {
		super(activatedRoute);
		this.setConfigExternalFormComponents([
            { resourceName: 'empresesFact', component: EmpresesFactFormComponent }
		]);
	}

}