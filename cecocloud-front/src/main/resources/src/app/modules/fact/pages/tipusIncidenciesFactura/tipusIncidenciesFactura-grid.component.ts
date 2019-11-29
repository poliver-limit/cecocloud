import { Component, OnInit } from '@angular/core';

import { TipusIncidenciesFacturaService } from './tipusIncidenciesFactura.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tipusIncidenciesFacturaService"></bng-datagrid>`
} )
export class TipusIncidenciesFacturaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tipusIncidenciesFacturaService: TipusIncidenciesFacturaService ) { }

}