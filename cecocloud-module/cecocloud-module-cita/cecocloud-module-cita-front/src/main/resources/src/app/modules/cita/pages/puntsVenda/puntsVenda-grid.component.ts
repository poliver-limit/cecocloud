import { Component } from '@angular/core';

import { PuntsVendaService } from './puntsVenda.service';

@Component({
	template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="puntsVendaService"></bng-datagrid>`
})
export class PuntsVendaGridComponent {

	datagridConfig = {
		columnFiltersEnabled: true,
		sort: [{
			fieldName: 'nom',
			direction: 'asc'
		}]
	};

	constructor(
		public puntsVendaService: PuntsVendaService) { }

}