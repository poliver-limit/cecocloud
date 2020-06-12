import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { VencimentsPagatService } from './vencimentsPagat.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="vencimentsPagatService"></bng-form>
`
} )
export class VencimentsPagatFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

     constructor(
		activatedRoute: ActivatedRoute,
        public vencimentsPagatService: VencimentsPagatService ) {
			super(activatedRoute);
		}

}