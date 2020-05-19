import { Component, OnInit } from '@angular/core';

import { TipusVencimentsService } from './tipusVenciments.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tipusVencimentsService"></bng-datagrid>`
} )
export class TipusVencimentsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tipusVencimentsService: TipusVencimentsService ) { }

}