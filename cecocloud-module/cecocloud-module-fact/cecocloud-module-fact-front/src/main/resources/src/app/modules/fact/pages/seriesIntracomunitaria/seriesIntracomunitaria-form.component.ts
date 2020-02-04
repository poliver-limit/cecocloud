import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { SeriesIntracomunitariaService } from './seriesIntracomunitaria.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="seriesIntracomunitariaService"></bng-form>
`
} )
export class SeriesIntracomunitariaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public seriesIntracomunitariaService: SeriesIntracomunitariaService ) { }

}