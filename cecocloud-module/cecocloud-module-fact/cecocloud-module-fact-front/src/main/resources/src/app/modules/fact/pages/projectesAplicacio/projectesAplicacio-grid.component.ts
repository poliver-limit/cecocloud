import { Component, OnInit } from '@angular/core';

import { ProjectesAplicacioService } from './projectesAplicacio.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="projectesAplicacioService"></bng-datagrid>`
} )
export class ProjectesAplicacioGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public projectesAplicacioService: ProjectesAplicacioService ) { }

}