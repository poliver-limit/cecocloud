import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { OficinesBancariesService } from './oficinesBancaries.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="oficinesBancariesService"></bng-form>
`
} )
export class OficinesBancariesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public oficinesBancariesService: OficinesBancariesService ) { }

}