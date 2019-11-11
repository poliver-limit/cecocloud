import { Component, OnInit } from '@angular/core';

import { RolsService } from './rols.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="rolsService"></bng-datagrid>`
} )
export class RolsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public rolsService: RolsService ) { }

}