import { Component, OnInit } from '@angular/core';

import { AvariesService } from './avaries.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="avariesService"></bng-datagrid>`
} )
export class AvariesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public avariesService: AvariesService ) { }

}