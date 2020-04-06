import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { ProjectesTarifaProveidorService } from './projectesTarifaProveidor.service';

import { ProveidorsFormComponent } from '../proveidors/proveidors-form.component';
import { TarifesProveidorFormComponent } from '../tarifesProveidor/tarifesProveidor-form.component';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="projectesTarifaProveidorService"></bng-form>
`
} )
export class ProjectesTarifaProveidorFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

   constructor(
		activatedRoute: ActivatedRoute,
        public projectesTarifaProveidorService: ProjectesTarifaProveidorService ) {
			super(activatedRoute);
			this.setConfigExternalFormComponents([
				{ resourceName: 'proveidor', component: ProveidorsFormComponent },
				{ resourceName: 'tarifaProveidor', component: TarifesProveidorFormComponent }
				])                  
		}
}