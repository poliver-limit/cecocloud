import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { ArticlesTraduccioService } from './articlesTraduccio.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="articlesTraduccioService"></bng-form>
`
} )
export class ArticlesTraduccioFormComponent extends BngFormBaseComponent {


    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public articlesTraduccioService: ArticlesTraduccioService ) {
			super(activatedRoute);
		}

}