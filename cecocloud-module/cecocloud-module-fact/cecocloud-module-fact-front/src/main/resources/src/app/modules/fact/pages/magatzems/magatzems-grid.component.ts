import { Component, OnInit } from '@angular/core';

import { MagatzemsService } from './magatzems.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="magatzemsService"></bng-datagrid>`
} )
export class MagatzemsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public magatzemsService: MagatzemsService ) { }

}