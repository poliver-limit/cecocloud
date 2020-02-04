import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ArticlesService } from './articles.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="articlesService"></bng-form>
`
} )
export class ArticlesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public articlesService: ArticlesService ) { }

}