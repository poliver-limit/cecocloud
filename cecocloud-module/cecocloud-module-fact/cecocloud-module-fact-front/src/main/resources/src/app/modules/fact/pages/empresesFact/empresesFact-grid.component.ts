import { Component, OnInit } from '@angular/core';

import { EmpresesFactService } from './empresesFact.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="empresesFactService"></bng-datagrid>`
} )
export class EmpresesFactGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public empresesFactService: EmpresesFactService ) { }

}