import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { ProjectesAplicacioService } from './projectesAplicacio.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="projectesAplicacioService"></bng-form>
`
} )
export class ProjectesAplicacioFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

   constructor(
		activatedRoute: ActivatedRoute,
        public projectesAplicacioService: ProjectesAplicacioService ) {
			super(activatedRoute);
		}
}