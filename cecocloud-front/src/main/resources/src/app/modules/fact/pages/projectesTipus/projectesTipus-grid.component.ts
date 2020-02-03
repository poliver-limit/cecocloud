import { Component, OnInit } from '@angular/core';

import { ProjectesTipusService } from './projectesTipus.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="projectesTipusService"></bng-datagrid>`
} )
export class ProjectesTipusGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public projectesTipusService: ProjectesTipusService ) { }

}