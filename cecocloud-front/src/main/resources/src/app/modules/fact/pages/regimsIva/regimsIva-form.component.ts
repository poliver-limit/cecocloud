import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { RegimsIvaService } from './regimsIva.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="regimsIvaService"></bng-form>
`
} )
export class RegimsIvaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public regimsIvaService: RegimsIvaService ) { }

}