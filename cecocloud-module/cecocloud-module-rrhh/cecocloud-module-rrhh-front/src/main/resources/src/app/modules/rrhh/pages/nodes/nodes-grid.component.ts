import { Component, OnInit } from '@angular/core';

import { NodesService } from './nodes.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="nodesService"></bng-datagrid>`
} )
export class NodesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public nodesService: NodesService ) { }

}