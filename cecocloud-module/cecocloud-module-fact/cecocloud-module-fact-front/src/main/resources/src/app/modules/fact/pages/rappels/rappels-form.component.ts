import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { RappelsService } from './rappels.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="rappelsService"></bng-form>
`
} )
export class RappelsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public rappelsService: RappelsService ) { }

}