import { Component, OnInit } from '@angular/core';

import { VencimentsService } from './venciments.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="vencimentsService"></bng-datagrid>`
} )
export class VencimentsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public vencimentsService: VencimentsService ) { }

}