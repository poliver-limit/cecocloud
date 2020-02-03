import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ParametresService } from './parametres.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="parametresService"></bng-form>
`
} )
export class ParametresFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public parametresService: ParametresService ) { }

}