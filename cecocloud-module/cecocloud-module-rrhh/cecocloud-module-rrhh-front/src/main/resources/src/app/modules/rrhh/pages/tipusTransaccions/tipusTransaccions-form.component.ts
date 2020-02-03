import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TipusTransaccionsService } from './tipusTransaccions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusTransaccionsService"></bng-form>
`
} )
export class TipusTransaccionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tipusTransaccionsService: TipusTransaccionsService ) { }

}