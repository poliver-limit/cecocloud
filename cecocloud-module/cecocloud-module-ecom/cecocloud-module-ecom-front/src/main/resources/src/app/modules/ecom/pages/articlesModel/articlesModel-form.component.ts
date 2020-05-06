import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ArticlesModelService } from './articlesModel.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="articlesModelService"></bng-form>
`
} )
export class ArticlesModelFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public articlesModelService: ArticlesModelService ) { }

}