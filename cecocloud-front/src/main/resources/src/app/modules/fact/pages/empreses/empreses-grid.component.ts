import { Component, OnInit } from '@angular/core';

import { EmpresesService } from './empreses.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="empresesService"></bng-datagrid>`
} )
export class EmpresesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public empresesService: EmpresesService ) { }

}