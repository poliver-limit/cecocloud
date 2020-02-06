import { Component, OnInit } from '@angular/core';

import { DivisesService } from './divises.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="divisesService"></bng-datagrid>`
} )
export class DivisesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public divisesService: DivisesService ) { }

}