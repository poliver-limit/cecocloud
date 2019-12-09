import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { SeccionsGrupService } from './seccionsGrup.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="seccionsGrupService"></bng-form>
`
} )
export class SeccionsGrupFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public seccionsGrupService: SeccionsGrupService ) { }

}