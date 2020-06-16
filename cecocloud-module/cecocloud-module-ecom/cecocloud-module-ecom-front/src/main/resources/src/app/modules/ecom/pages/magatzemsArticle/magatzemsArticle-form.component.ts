import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { MagatzemsArticleService } from './magatzemsArticle.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="magatzemsArticleService"></bng-form>
`
} )
export class MagatzemsArticleFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public magatzemsArticleService: MagatzemsArticleService ) { }

}