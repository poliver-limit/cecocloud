import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TipusComissionsService } from './tipusComissions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusComissionsService"></bng-form>
`
} )
export class TipusComissionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tipusComissionsService: TipusComissionsService ) { }

}