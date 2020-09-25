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
		columns: [{
			field: 'operariEmpresa'
		}, {
			field: 'data'
		}, {
			field: 'origen'
		}, {
			field: 'ubicacio',
			sortable: false
		}, {
			field: 'validat',
			width: 1,
			cellRenderer: function(params) {
				let rgbColor = params.value ? '#b0ffb0' : '#ffb0b0';
				return '<div style="text-align:center;background-color:' + rgbColor + '">' + params.valueFormatted + '</div>';
			}
		}],
		sort: [{
			fieldName: 'operariEmpresa',
			direction: 'asc'
		}, {
			fieldName: 'data',
			direction: 'desc'
		}]
	};

	ngOnInit() {
	}

	constructor(
		public marcatgesService: MarcatgesService) { }

}