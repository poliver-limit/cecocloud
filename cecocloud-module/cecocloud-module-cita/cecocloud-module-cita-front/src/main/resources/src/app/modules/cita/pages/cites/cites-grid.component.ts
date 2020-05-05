import { Component, OnInit } from '@angular/core';

import { CitesService } from './cites.service';

@Component({
	template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="citesService"></bng-datagrid>`
})
export class CitesGridComponent {

	datagridConfig = {
		columnFiltersEnabled: true,
		sort: [{
			fieldName: 'operariEmpresa',
			direction: 'asc'
		}, {
			fieldName: 'data',
			direction: 'desc'
		}]
	};

	constructor(
		public citesService: CitesService) { }

}