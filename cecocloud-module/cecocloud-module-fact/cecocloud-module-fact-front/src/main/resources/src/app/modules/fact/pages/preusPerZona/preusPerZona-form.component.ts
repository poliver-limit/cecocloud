import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { PreusPerZonaService } from './preusPerZona.service';
import { ZonesFormComponent } from '../zones/zones-form.component'
import { TransportistesFormComponent } from '../transportistes/transportistes-form.component'

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="preusPerZonaService"></bng-form>
`
} )
export class PreusPerZonaFormComponent extends BngFormBaseComponent{


    constructor(
		activatedRoute: ActivatedRoute,
        public preusPerZonaService: PreusPerZonaService) {
		super(activatedRoute);
		this.setConfigExternalFormComponents([
            { resourceName: 'zona', component: ZonesFormComponent },
            { resourceName: 'transportista', component: TransportistesFormComponent }
		]);
	}

}