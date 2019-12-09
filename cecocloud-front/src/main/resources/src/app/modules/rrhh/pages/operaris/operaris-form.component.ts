import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { OperarisService } from './operaris.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="operarisService"></bng-form>
`
} )
export class OperarisFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public operarisService: OperarisService ) { }

}