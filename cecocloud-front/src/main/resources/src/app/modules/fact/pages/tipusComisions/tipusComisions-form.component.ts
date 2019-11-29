import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TipusComisionsService } from './tipusComisions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusComisionsService"></bng-form>
`
} )
export class TipusComisionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tipusComisionsService: TipusComisionsService ) { }

}