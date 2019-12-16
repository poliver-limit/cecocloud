import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { EmpresesRrhhService } from './empresesRrhh.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="empresesRrhhService"></bng-form>
`
} )
export class EmpresesRrhhFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public empresesRrhhService: EmpresesRrhhService ) { }

}