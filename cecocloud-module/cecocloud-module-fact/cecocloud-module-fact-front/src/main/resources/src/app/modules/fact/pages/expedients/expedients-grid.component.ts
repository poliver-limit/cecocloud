import { Component, OnInit } from '@angular/core';

import { ExpedientsService } from './expedients.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="expedientsService"></bng-datagrid>`
} )
export class ExpedientsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public expedientsService: ExpedientsService ) { }

}