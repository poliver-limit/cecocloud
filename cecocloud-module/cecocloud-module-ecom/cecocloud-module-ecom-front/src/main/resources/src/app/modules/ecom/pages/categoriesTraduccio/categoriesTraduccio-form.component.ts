import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { CategoriesTraduccioService } from './categoriesTraduccio.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="categoriesTraduccioService"></bng-form>
`
} )
export class CategoriesTraduccioFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

     constructor(
		activatedRoute: ActivatedRoute,
        public categoriesTraduccioService: CategoriesTraduccioService ) {
			super(activatedRoute);
		}

}