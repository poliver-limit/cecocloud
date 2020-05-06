import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ArticlesFamiliaService } from './articlesFamilia.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="articlesFamiliaService"></bng-form>
`
} )
export class ArticlesFamiliaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public articlesFamiliaService: ArticlesFamiliaService ) { }

}