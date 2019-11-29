import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TipusIncidenciesFacturaService } from './tipusIncidenciesFactura.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusIncidenciesFacturaService"></bng-form>
`
} )
export class TipusIncidenciesFacturaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tipusIncidenciesFacturaService: TipusIncidenciesFacturaService ) { }

}