import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { SubcategoriesService } from './subcategories.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="subcategoriesService"></bng-form>
`
} )
export class SubcategoriesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public subcategoriesService: SubcategoriesService ) { }

}