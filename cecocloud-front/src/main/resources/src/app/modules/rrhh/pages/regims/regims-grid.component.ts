import { Component, OnInit } from '@angular/core';

import { RegimsService } from './regims.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="regimsService"></bng-datagrid>`
} )
export class RegimsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public regimsService: RegimsService ) { }

}