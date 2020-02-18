import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TipusAdrecesService } from './tipusAdreces.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusAdrecesService"></bng-form>
`
} )
export class TipusAdrecesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tipusAdrecesService: TipusAdrecesService ) { }

}