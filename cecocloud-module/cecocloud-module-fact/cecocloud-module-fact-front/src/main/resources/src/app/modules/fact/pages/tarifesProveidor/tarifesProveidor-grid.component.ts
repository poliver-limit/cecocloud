import { Component, OnInit } from '@angular/core';

import { TarifesProveidorService } from './tarifesProveidor.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tarifesProveidorService"></bng-datagrid>`
} )
export class TarifesProveidorGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tarifesProveidorService: TarifesProveidorService ) { }

}