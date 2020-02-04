import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { SeriesCompraService } from './seriesCompra.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="seriesCompraService"></bng-form>
`
} )
export class SeriesCompraFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public seriesCompraService: SeriesCompraService ) { }

}