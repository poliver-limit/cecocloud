import { Component, OnInit } from '@angular/core';

import { TipusTransaccionsService } from './tipusTransaccions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tipusTransaccionsService"></bng-datagrid>`
} )
export class TipusTransaccionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tipusTransaccionsService: TipusTransaccionsService ) { }

}