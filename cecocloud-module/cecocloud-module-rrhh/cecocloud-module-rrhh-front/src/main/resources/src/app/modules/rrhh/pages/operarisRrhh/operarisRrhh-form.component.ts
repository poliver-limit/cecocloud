import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { OperarisRrhhService } from './operarisRrhh.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="operarisRrhhService"></bng-form>
`
} )
export class OperarisRrhhFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public operarisRrhhService: OperarisRrhhService ) { }

}