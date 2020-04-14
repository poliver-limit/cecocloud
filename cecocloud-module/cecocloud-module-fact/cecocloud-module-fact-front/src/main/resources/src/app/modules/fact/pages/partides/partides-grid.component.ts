import { Component, OnInit } from '@angular/core';

import { PartidesService } from './partides.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="partidesService"></bng-datagrid>`
} )
export class PartidesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public partidesService: PartidesService ) { }

}