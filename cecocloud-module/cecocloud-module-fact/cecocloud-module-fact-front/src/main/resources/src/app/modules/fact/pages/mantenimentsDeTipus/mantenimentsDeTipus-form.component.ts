import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { MantenimentsDeTipusService } from './mantenimentsDeTipus.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="mantenimentsDeTipusService"></bng-form>
`
} )
export class MantenimentsDeTipusFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

     constructor(
		activatedRoute: ActivatedRoute,
        public mantenimentsDeTipusService: MantenimentsDeTipusService ) {
			super(activatedRoute);
		}

}