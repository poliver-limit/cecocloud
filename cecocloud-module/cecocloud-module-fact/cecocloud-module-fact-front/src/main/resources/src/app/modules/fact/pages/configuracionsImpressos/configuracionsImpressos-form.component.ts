import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { ConfiguracionsImpressosService } from './configuracionsImpressos.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="configuracionsImpressosService"></bng-form>
`
} )
export class ConfiguracionsImpressosFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public configuracionsImpressosService: ConfiguracionsImpressosService ) {
			super(activatedRoute);
		}
}