import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { ClassesRetencionsService } from './classesRetencions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="classesRetencionsService"></bng-form>
`
} )
export class ClassesRetencionsFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

     constructor(
		activatedRoute: ActivatedRoute,
        public classesRetencionsService: ClassesRetencionsService ) {
			super(activatedRoute);
		}
}