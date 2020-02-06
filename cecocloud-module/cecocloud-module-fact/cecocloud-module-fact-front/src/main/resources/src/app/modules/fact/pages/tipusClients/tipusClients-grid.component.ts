import { Component, OnInit } from '@angular/core';

import { TipusClientsService } from './tipusClients.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tipusClientsService"></bng-datagrid>`
} )
export class TipusClientsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tipusClientsService: TipusClientsService ) { }

}