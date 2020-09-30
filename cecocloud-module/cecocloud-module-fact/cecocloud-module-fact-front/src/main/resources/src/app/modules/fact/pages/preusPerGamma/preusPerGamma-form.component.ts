import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { PreusPerGammaService } from './preusPerGamma.service';
import { ArticlesGammaFormComponent } from '../articlesGamma/articlesGamma-form.component';
import { TransportistesFormComponent } from '../transportistes/transportistes-form.component'

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="preusPerGammaService"></bng-form>
`
} )
export class PreusPerGammaFormComponent extends BngFormBaseComponent{


    constructor(
		activatedRoute: ActivatedRoute,
        public preusPerGammaService: PreusPerGammaService) {
		super(activatedRoute);
		this.setConfigExternalFormComponents([
            { resourceName: 'gamma', component: ArticlesGammaFormComponent },
            { resourceName: 'transportista', component: TransportistesFormComponent }
		]);
	}

}