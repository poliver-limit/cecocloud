import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { SituacionsInicialService } from './situacionsInicial.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="situacionsInicialService"></bng-form>
`
} )
export class SituacionsInicialFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public situacionsInicialService: SituacionsInicialService ) { }

}