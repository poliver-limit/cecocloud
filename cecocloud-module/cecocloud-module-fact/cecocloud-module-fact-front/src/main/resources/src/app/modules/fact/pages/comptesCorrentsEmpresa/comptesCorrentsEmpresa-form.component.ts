import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ComptesCorrentsEmpresaService } from './comptesCorrentsEmpresa.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="comptesCorrentsEmpresaService"></bng-form>
`
} )
export class ComptesCorrentsEmpresaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public comptesCorrentsEmpresaService: ComptesCorrentsEmpresaService ) { }

}