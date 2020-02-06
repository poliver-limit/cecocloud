import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ComptesComptablesEmpresaService } from './comptesComptablesEmpresa.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="comptesComptablesEmpresaService"></bng-form>
`
} )
export class ComptesComptablesEmpresaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public comptesComptablesEmpresaService: ComptesComptablesEmpresaService ) { }

}