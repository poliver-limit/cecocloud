import { Component, OnInit } from '@angular/core';

import { DepartamentsClientService } from './departamentsClient.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="departamentsClientService"></bng-datagrid>`
} )
export class DepartamentsClientGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public departamentsClientService: DepartamentsClientService ) { }

}