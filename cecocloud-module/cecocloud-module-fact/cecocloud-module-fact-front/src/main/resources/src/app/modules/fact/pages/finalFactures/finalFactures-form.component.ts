import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { FinalFacturesService } from './finalFactures.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="finalFacturesService"></bng-form>
`
} )
export class FinalFacturesFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public finalFacturesService: FinalFacturesService ) {
			super(activatedRoute);
 		}

}