import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { ProveidorsVencimentService } from './proveidorsVenciment.service';

import { ProveidorsFormComponent } from '../proveidors/proveidors-form.component';
import { TipusVencimentsFormComponent } from '../tipusVenciments/tipusVenciments-form.component';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="proveidorsVencimentService"></bng-form>
`
} )
export class ProveidorsVencimentFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

   constructor(
		activatedRoute: ActivatedRoute,
        public proveidorsVencimentService: ProveidorsVencimentService ) {
			super(activatedRoute);
			this.setConfigExternalFormComponents([
				{ resourceName: 'proveidor', component: ProveidorsFormComponent },
				{ resourceName: 'tipusVenciment', component: TipusVencimentsFormComponent }
				])                  
		}
}