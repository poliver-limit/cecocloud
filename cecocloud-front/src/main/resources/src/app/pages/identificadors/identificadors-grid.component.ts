import { Component, OnInit } from '@angular/core';

import { IdentificadorsService } from './identificadors.service';

@Component({
	template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="identificadorsService"></bng-datagrid>`
})
export class IdentificadorsGridComponent implements OnInit {

	datagridConfig = {
		columnFiltersEnabled: true
	};

	ngOnInit() {
	}

	constructor(
		public identificadorsService: IdentificadorsService) { }

}