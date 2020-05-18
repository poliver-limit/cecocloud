import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { ArticlesInformacioService } from './articlesInformacio.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="articlesInformacioService"></bng-form>
`
} )
export class ArticlesInformacioFormComponent extends BngFormBaseComponent {


//    formConfig: BngFormConfig = {
//    }

    constructor(
		activatedRoute: ActivatedRoute,
        public articlesInformacioService: ArticlesInformacioService ) {
			super(activatedRoute);
		}

}