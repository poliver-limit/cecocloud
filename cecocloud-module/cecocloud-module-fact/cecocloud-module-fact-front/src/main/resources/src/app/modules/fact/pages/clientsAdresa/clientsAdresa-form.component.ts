import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ClientsAdresaService } from './clientsAdresa.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="clientsAdresaService"></bng-form>
`
} )
export class ClientsAdresaFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public clientsAdresaService: ClientsAdresaService ) { }

}