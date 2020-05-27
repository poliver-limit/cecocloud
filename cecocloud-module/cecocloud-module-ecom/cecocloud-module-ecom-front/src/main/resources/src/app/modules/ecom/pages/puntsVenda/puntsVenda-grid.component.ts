import { Component, OnInit } from '@angular/core';

import { PuntsVendaService } from './puntsVenda.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="puntsVendaService"></bng-datagrid>`
} )
export class PuntsVendaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public puntsVendaService: PuntsVendaService ) { }

}