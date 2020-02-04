import { Component, OnInit } from '@angular/core';

import { DepartamentsService } from './departaments.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="departamentsService"></bng-datagrid>`
} )
export class DepartamentsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public departamentsService: DepartamentsService ) { }

}