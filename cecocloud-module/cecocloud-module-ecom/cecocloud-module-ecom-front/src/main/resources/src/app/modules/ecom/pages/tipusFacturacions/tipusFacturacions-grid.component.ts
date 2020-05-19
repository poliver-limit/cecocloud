import { Component, OnInit } from '@angular/core';

import { TipusFacturacionsService } from './tipusFacturacions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tipusFacturacionsService"></bng-datagrid>`
} )
export class TipusFacturacionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tipusFacturacionsService: TipusFacturacionsService ) { }

}