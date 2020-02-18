import { Component } from '@angular/core';
import { BngFormConfig, BngDatagridConfig } from 'base-angular';

import { ClientsService } from './clients.service';
import { DepartamentsClientService } from '../departamentsClient/departamentsClient.service';

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

	departamentsDatagridConfig: BngDatagridConfig = {
		mode: 'form',
		columns: [{
			field: 'nom'
		}]
	};
	
    datagridConfig = {
        //editable: true,
//		mode: 'form',
        columnFiltersEnabled: false
    };

    constructor(
        public clientsService: ClientsService,
		public departamentsService: DepartamentsClientService
		 ) { }

}