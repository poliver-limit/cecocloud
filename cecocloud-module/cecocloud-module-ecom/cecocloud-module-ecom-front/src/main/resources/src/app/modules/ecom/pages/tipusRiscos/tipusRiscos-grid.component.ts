import { Component, OnInit } from '@angular/core';

import { TipusRiscosService } from './tipusRiscos.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tipusRiscosService"></bng-datagrid>`
} )
export class TipusRiscosGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tipusRiscosService: TipusRiscosService ) { }

}