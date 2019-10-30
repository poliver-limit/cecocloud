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
		//editable: true,
		columnFiltersEnabled: true,
		sort: [
			{ fieldName: 'operari', direction: 'asc' },
			{ fieldName: 'data', direction: 'desc' }
		]
        /*columns: [{
            field: 'operari',
            sort: 'asc'
        }, {
            field: 'data',
            sort: 'desc'
        }, {
            field: 'origen'
        }, {
            field: 'ubicacio'
        }]*/
	};

	ngOnInit() {
	}

	constructor(
		public marcatgesService: MarcatgesService) { }

}