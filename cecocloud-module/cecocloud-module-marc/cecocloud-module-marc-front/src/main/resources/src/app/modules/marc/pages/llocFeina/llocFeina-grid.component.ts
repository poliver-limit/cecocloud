import { Component } from '@angular/core';

import { LlocFeinaService } from './llocFeina.service';

@Component({
	template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="llocFeinaService"></bng-datagrid>`
})
export class LlocFeinaGridComponent {

	datagridConfig = {
		columnFiltersEnabled: true,
		sort: [{
			fieldName: 'nom',
			direction: 'asc'
		}]
	};

	constructor(
		public llocFeinaService: LlocFeinaService) { }

}