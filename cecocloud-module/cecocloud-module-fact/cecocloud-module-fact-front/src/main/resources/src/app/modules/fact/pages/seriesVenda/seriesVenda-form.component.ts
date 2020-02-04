import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { SeriesVendaService } from './seriesVenda.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="seriesVendaService"></bng-form>
`
} )
export class SeriesVendaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public seriesVendaService: SeriesVendaService ) { }

}