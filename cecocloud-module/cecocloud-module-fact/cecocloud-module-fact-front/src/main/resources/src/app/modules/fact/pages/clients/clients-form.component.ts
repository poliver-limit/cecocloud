import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ClientsService } from './clients.service';

@Component( {
	templateUrl: 'clients-form.html'
//    template: `
//    <bng-form
//        bng-form-mant
//        [config]="formConfig"
//        [restapiService]="clientsService"></bng-form>
//`
} )
export class ClientsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public clientsService: ClientsService ) { }

}