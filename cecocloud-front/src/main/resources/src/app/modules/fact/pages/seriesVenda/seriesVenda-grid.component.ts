import { Component, OnInit } from '@angular/core';

import { SeriesVendaService } from './seriesVenda.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="seriesVendaService"></bng-datagrid>`
} )
export class SeriesVendaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public seriesVendaService: SeriesVendaService ) { }

}