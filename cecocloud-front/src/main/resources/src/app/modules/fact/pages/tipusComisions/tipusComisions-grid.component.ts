import { Component, OnInit } from '@angular/core';

import { TipusComisionsService } from './tipusComisions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tipusComisionsService"></bng-datagrid>`
} )
export class TipusComisionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tipusComisionsService: TipusComisionsService ) { }

}