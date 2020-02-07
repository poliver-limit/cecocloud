import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { SubClientsService } from './subClients.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="subClientsService"></bng-form>
`
} )
export class SubClientsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public subClientsService: SubClientsService ) { }

}