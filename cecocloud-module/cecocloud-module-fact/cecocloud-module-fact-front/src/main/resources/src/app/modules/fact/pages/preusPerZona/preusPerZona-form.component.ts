import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { PreusPerZonaService } from './preusPerZona.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="preusPerZonaService"></bng-form>
`
} )
export class PreusPerZonaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public preusPerZonaService: PreusPerZonaService ) { }

}