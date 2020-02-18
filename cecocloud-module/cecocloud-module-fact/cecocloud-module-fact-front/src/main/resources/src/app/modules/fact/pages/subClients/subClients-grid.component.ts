import { Component, OnInit } from '@angular/core';

import { SubClientsService } from './subClients.service';

@Component( {
	selector: 'subClient',
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="subClientsService"></bng-datagrid>`
} )
export class SubClientsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public subClientsService: SubClientsService ) { }

}