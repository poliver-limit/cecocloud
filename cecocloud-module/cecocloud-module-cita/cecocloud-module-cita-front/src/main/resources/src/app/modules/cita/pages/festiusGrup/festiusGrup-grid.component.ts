import { Component } from '@angular/core';

import { FestiusGrupService } from './festiusGrup.service';

@Component({
	template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="festiusGrupService"></bng-datagrid>`
})
export class FestiusGrupGridComponent {

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
		public festiusGrupService: FestiusGrupService) { }

}