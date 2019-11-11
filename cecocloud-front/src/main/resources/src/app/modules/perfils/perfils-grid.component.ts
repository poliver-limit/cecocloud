import { Component, OnInit } from '@angular/core';

import { PerfilsService } from './perfils.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="perfilsService"></bng-datagrid>`
} )
export class PerfilsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public perfilsService: PerfilsService ) { }

}