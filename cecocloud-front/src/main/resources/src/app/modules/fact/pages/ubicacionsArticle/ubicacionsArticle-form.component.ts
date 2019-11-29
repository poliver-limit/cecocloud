import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { UbicacionsArticleService } from './ubicacionsArticle.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="ubicacionsArticleService"></bng-form>
`
} )
export class UbicacionsArticleFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public ubicacionsArticleService: UbicacionsArticleService ) { }

}