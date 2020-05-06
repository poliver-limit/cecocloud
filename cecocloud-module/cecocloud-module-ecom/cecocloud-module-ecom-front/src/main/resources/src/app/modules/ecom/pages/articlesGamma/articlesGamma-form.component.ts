import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ArticlesGammaService } from './articlesGamma.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="articlesGammaService"></bng-form>
`
} )
export class ArticlesGammaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public articlesGammaService: ArticlesGammaService ) { }

}