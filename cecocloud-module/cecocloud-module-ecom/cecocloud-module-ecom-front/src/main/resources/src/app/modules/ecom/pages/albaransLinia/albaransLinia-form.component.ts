import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { AlbaransLiniaService } from './albaransLinia.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="albaransLiniaService"></bng-form>
`
} )
export class AlbaransLiniaFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public albaransLiniaService: AlbaransLiniaService ) { 
		super(activatedRoute);
		}

}