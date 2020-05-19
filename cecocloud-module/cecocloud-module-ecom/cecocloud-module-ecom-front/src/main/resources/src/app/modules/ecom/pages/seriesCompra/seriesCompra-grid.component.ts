import { Component, OnInit } from '@angular/core';

import { SeriesCompraService } from './seriesCompra.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="seriesCompraService"></bng-datagrid>`
} )
export class SeriesCompraGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public seriesCompraService: SeriesCompraService ) { }

}