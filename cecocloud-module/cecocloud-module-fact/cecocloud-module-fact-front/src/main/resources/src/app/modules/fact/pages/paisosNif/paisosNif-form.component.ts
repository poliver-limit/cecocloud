import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { PaisosNifService } from './paisosNif.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="paisosNifService"></bng-form>
`
} )
export class PaisosNifFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public paisosNifService: PaisosNifService ){
			super(activatedRoute);
		}
}