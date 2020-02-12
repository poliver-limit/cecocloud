import { Component, OnInit } from '@angular/core';

import { LicitacionsService } from './licitacions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="licitacionsService"></bng-datagrid>`
} )
export class LicitacionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public licitacionsService: LicitacionsService ) { }

}