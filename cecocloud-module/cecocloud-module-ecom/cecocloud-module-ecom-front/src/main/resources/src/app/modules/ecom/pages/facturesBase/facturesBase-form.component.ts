import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { FacturesBaseService } from './facturesBase.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="facturesBaseService"></bng-form>
`
} )
export class FacturesBaseFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

     constructor(
		activatedRoute: ActivatedRoute,
        public facturesBaseService: FacturesBaseService ) {
			super(activatedRoute);
		}

}