import { Component, OnInit } from '@angular/core';

import { MarcatgesService } from './marcatges.service';

@Component({
	template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="marcatgesService"></bng-datagrid>`
})
export class MarcatgesGridComponent implements OnInit {

	datagridConfig = {
		columnFiltersEnabled: true,
		sort: [
			{ fieldName: 'operari', direction: 'asc' },
			{ fieldName: 'data', direction: 'desc' }
		]
	};

	ngOnInit() {
	}

	constructor(
		public marcatgesService: MarcatgesService) { }

}