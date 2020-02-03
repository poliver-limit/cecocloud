import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { RegimsService } from './regims.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="regimsService"></bng-form>
`
} )
export class RegimsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public regimsService: RegimsService ) { }

}