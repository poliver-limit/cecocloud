import { Component, OnInit } from '@angular/core';

import { TipusAdrecesService } from './tipusAdreces.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tipusAdrecesService"></bng-datagrid>`
} )
export class TipusAdrecesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tipusAdrecesService: TipusAdrecesService ) { }

}