import { Component, OnInit } from '@angular/core';

import { ProjectesPressupostService } from './projectesPressupost.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="projectesPressupostService"></bng-datagrid>`
} )
export class ProjectesPressupostGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public projectesPressupostService: ProjectesPressupostService ) { }

}