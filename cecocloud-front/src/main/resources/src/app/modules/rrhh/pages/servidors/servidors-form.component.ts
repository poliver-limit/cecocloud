import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ServidorsService } from './servidors.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="servidorsService"></bng-form>
`
} )
export class ServidorsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public servidorsService: ServidorsService ) { }

}