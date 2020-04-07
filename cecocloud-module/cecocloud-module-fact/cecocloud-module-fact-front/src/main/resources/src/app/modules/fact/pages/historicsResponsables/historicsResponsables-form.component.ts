import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { HistoricsResponsablesService } from './historicsResponsables.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="historicsResponsablesService"></bng-form>
`
} )
export class HistoricsResponsablesFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

     constructor(
		activatedRoute: ActivatedRoute,
        public historicsResponsablesService: HistoricsResponsablesService ) {
			super(activatedRoute);
		}

}