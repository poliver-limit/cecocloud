import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { PressupostosLiniaService } from './pressupostosLinia.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="pressupostosLiniaService"></bng-form>
`
} )
export class PressupostosLiniaFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public pressupostosLiniaService: PressupostosLiniaService ) { 
		super(activatedRoute);
		}

}