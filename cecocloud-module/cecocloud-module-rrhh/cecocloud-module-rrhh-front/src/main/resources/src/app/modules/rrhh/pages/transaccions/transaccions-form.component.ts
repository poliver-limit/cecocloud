import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TransaccionsService } from './transaccions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="transaccionsService"></bng-form>
`
} )
export class TransaccionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public transaccionsService: TransaccionsService ) { }

}