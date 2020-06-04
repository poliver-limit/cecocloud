import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TipusUnitatsService } from './tipusUnitats.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusUnitatsService"></bng-form>
`
} )
export class TipusUnitatsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tipusUnitatsService: TipusUnitatsService ) { }

}