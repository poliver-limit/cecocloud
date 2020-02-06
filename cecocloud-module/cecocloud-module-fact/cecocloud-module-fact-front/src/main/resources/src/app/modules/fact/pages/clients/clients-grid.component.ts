import { Component, OnInit } from '@angular/core';

import { ClientsService } from './clients.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="clientsService"></bng-datagrid>`
} )
export class ClientsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public clientsService: ClientsService ) { }

}