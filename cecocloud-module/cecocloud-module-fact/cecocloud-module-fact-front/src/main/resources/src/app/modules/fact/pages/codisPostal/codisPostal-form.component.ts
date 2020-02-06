import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { CodisPostalService } from './codisPostal.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="codisPostalService"></bng-form>
`
} )
export class CodisPostalFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public codisPostalService: CodisPostalService ) { }

}