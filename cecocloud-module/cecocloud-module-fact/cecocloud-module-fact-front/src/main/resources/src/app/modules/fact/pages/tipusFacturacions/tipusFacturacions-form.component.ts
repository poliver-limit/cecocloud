import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TipusFacturacionsService } from './tipusFacturacions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusFacturacionsService"></bng-form>
`
} )
export class TipusFacturacionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tipusFacturacionsService: TipusFacturacionsService ) { }

}