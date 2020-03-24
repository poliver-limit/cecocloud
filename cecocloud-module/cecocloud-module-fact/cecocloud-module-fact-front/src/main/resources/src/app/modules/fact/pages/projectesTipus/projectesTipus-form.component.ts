import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { ProjectesTipusService } from './projectesTipus.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="projectesTipusService"></bng-form>
`
} )
export class ProjectesTipusFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public projectesTipusService: ProjectesTipusService ) { 
			super(activatedRoute);
		}

}