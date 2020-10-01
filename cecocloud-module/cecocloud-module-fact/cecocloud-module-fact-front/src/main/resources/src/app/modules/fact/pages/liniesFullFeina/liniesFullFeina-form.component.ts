import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { LiniesFullFeinaService } from './liniesFullFeina.service';
import { FinalFacturesFormComponent } from '../finalFactures/finalFactures-form.component'

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="liniesFullFeinaService"></bng-form>
`
} )
export class LiniesFullFeinaFormComponent extends BngFormBaseComponent{


    constructor(
		activatedRoute: ActivatedRoute,
        public liniesFullFeinaService: LiniesFullFeinaService) {
		super(activatedRoute);
		this.setConfigExternalFormComponents([
			{ resourceName: 'finalFactura', component: FinalFacturesFormComponent }
		]);
	}

}