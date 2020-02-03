import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { CategoriesService } from './categories.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="categoriesService"></bng-form>
`
} )
export class CategoriesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public categoriesService: CategoriesService ) { }

}