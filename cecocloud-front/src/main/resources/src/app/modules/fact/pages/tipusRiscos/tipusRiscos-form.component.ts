import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TipusRiscosService } from './tipusRiscos.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusRiscosService"></bng-form>
`
} )
export class TipusRiscosFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tipusRiscosService: TipusRiscosService ) { }

}