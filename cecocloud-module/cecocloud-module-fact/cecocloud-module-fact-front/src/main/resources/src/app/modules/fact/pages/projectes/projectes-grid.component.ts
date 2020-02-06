import { Component, OnInit } from '@angular/core';

import { ProjectesService } from './projectes.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="projectesService"></bng-datagrid>`
} )
export class ProjectesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public projectesService: ProjectesService ) { }

}