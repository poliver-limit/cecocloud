import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ArticlesMarcaService } from './articlesMarca.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="articlesMarcaService"></bng-form>
`
} )
export class ArticlesMarcaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public articlesMarcaService: ArticlesMarcaService ) { }

}