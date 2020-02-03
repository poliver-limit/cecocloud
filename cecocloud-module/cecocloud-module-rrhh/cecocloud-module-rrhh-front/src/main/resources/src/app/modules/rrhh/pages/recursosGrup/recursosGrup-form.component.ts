import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { RecursosGrupService } from './recursosGrup.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="recursosGrupService"></bng-form>
`
} )
export class RecursosGrupFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public recursosGrupService: RecursosGrupService ) { }

}