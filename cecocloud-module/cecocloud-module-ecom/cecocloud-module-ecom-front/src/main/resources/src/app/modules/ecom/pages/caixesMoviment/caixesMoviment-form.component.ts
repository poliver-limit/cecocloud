import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { CaixesMovimentService } from './caixesMoviment.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="caixesMovimentService"></bng-form>
`
} )
export class CaixesMovimentFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

     constructor(
		activatedRoute: ActivatedRoute,
        public caixesMovimentService: CaixesMovimentService ) {
			super(activatedRoute);
		}

}