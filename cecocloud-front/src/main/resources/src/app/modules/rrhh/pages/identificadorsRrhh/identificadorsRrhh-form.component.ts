import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { IdentificadorsRrhhService } from './identificadorsRrhh.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="identificadorsRrhhService"></bng-form>
`
} )
export class IdentificadorsRrhhFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public identificadorsRrhhService: IdentificadorsRrhhService ) { }

}