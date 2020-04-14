import { Component, OnInit } from '@angular/core';

import { CapitolsService } from './capitols.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="capitolsService"></bng-datagrid>`
} )
export class CapitolsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public capitolsService: CapitolsService ) { }

}