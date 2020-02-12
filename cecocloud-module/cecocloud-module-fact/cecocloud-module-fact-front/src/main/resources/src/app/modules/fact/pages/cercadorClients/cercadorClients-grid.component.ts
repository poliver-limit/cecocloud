import { Component, OnInit } from '@angular/core';

import { CercadorClientsService } from './cercadorClients.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="cercadorClientsService"></bng-datagrid>`
} )
export class CercadorClientsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public cercadorClientsService: CercadorClientsService ) { }

}