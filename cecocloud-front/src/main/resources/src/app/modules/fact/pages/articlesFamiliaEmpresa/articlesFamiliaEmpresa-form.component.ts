import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ArticlesFamiliaEmpresaService } from './articlesFamiliaEmpresa.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="articlesFamiliaEmpresaService"></bng-form>
`
} )
export class ArticlesFamiliaEmpresaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public articlesFamiliaEmpresaService: ArticlesFamiliaEmpresaService ) { }

}