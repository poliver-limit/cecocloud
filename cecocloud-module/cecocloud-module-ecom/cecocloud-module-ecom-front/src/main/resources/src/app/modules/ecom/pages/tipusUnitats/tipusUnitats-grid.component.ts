import { Component, OnInit } from '@angular/core';

import { TipusUnitatsService } from './tipusUnitats.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tipusUnitatsService"></bng-datagrid>`
} )
export class TipusUnitatsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tipusUnitatsService: TipusUnitatsService ) { }

}