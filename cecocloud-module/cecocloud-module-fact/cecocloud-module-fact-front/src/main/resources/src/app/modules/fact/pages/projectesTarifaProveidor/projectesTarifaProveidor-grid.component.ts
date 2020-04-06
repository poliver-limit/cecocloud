import { Component, OnInit } from '@angular/core';

import { ProjectesTarifaProveidorService } from './projectesTarifaProveidor.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="projectesTarifaProveidorService"></bng-datagrid>`
} )
export class ProjectesTarifaProveidorGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public projectesTarifaProveidorService: ProjectesTarifaProveidorService ) { }

}