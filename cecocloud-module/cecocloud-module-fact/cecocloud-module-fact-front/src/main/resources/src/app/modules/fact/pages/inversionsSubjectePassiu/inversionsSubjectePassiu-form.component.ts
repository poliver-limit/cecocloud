import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { InversionsSubjectePassiuService } from './inversionsSubjectePassiu.service';

import { ProveidorsFormComponent } from '../proveidors/proveidors-form.component';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="inversionsSubjectePassiuService"></bng-form>
`
} )
export class InversionsSubjectePassiuFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

   constructor(
		activatedRoute: ActivatedRoute,
        public inversionsSubjectePassiuService: InversionsSubjectePassiuService ) {
			super(activatedRoute);
			this.setConfigExternalFormComponents([
				{ resourceName: 'proveidor', component: ProveidorsFormComponent }				
				])                  
		}
}