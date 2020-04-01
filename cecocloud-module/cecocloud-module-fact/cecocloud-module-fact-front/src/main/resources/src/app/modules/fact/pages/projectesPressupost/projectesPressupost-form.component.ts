import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent, BngFormErrorMessages } from 'base-angular';
import { ProjectesPressupostService } from './projectesPressupost.service';
import { FormGroup } from '@angular/forms';

@Component( {
	template: `<bng-form
  			bng-form-mant
  			[config]="formConfig"
  			[restapiService]="projectesPressupostService"  			
			>`
} )

export class ProjectesPressupostFormComponent extends BngFormBaseComponent {
	
	formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public projectesPressupostService: ProjectesPressupostService ) { 
			super(activatedRoute);		
			this.setConfigExternalFormComponents([			
			])
		}
}