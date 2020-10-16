import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { LiniesEstudiService } from './liniesEstudi.service';
import { EmpresesFactFormComponent } from '../empresesFact/empresesFact-form.component';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="liniesEstudiService"></bng-form>
`
} )
export class LiniesEstudiFormComponent extends BngFormBaseComponent{


    constructor(
		activatedRoute: ActivatedRoute,
        public liniesEstudiService: LiniesEstudiService) {
		super(activatedRoute);
		this.setConfigExternalFormComponents([
            { resourceName: 'empresesFact', component: EmpresesFactFormComponent }
		]);
	}

}