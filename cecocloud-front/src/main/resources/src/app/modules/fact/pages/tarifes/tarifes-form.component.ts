import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TarifesService } from './tarifes.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tarifesService"></bng-form>
`
} )
export class TarifesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tarifesService: TarifesService ) { }

}