import { Component, OnInit } from '@angular/core';

import { ClientsAdresaService } from './clientsAdresa.service';

@Component( {
	selector: 'clientAdresa',
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="clientsAdresaService"></bng-datagrid>`
} )
export class ClientsAdresaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public clientsAdresaService: ClientsAdresaService ) { }

}