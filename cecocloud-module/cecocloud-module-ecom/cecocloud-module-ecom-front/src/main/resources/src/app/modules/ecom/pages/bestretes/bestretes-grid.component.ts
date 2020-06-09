import { Component, OnInit } from '@angular/core';

import { BestretesService } from './bestretes.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="bestretesService"></bng-datagrid>`
} )
export class BestretesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public bestretesService: BestretesService ) { }

}