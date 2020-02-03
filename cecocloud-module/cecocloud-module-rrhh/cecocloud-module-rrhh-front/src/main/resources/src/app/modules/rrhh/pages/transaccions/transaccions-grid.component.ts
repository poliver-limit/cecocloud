import { Component, OnInit } from '@angular/core';

import { TransaccionsService } from './transaccions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="transaccionsService"></bng-datagrid>`
} )
export class TransaccionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public transaccionsService: TransaccionsService ) { }

}