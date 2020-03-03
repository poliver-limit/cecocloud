import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { ProductesService } from './productes.service';
import { EmpresesFactFormComponent } from '../empresesFact/empresesFact-form.component'

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="productesService"></bng-form>
`
} )
export class ProductesFormComponent extends BngFormBaseComponent {

    constructor(
		activatedRoute: ActivatedRoute,
        public productesService: ProductesService) {
		super(activatedRoute);
		this.setConfigExternalFormComponents([
			{ resourceName: 'empresa', component: EmpresesFactFormComponent }
		]);
	}

}