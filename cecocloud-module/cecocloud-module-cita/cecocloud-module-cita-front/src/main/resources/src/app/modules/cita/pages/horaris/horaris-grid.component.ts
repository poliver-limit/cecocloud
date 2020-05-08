import { Component } from '@angular/core';

import { HorarisService } from './horaris.service';

@Component({
	template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="horarisService"></bng-datagrid>`
})
export class HorarisGridComponent {

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
		public horarisService: HorarisService) { }

}