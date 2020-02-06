import { Component, OnInit } from '@angular/core';

import { RappelsService } from './rappels.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="rappelsService"></bng-datagrid>`
} )
export class RappelsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public rappelsService: RappelsService ) { }

}