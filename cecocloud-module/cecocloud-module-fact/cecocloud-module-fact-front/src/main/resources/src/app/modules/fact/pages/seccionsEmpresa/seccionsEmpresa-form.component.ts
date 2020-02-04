import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { SeccionsEmpresaService } from './seccionsEmpresa.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="seccionsEmpresaService"></bng-form>
`
} )
export class SeccionsEmpresaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public seccionsEmpresaService: SeccionsEmpresaService ) { }

}