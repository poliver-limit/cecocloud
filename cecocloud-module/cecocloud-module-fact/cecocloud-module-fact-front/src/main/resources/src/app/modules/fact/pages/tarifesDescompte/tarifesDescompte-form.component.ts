import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { TarifesDescompteService } from './tarifesDescompte.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tarifesDescompteService"></bng-form>
`
} )
export class TarifesDescompteFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public tarifesDescompteService: TarifesDescompteService ) {
			super(activatedRoute);
		}
}