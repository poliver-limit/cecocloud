import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TipusClientsService } from './tipusClients.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusClientsService"></bng-form>
`
} )
export class TipusClientsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tipusClientsService: TipusClientsService ) { }

}