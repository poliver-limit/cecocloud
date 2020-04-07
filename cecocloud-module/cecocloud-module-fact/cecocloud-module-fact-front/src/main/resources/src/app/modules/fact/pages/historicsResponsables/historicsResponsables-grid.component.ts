import { Component, OnInit } from '@angular/core';

import { HistoricsResponsablesService } from './historicsResponsables.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="historicsResponsablesService"></bng-datagrid>`
} )
export class HistoricsResponsablesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public historicsResponsablesService: HistoricsResponsablesService ) { }

}