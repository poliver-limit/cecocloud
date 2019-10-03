import { Component, OnInit } from '@angular/core';

import { CpktestService } from './cpktest.service';

@Component( {
    template: `
    <datagrid
        datagrid-mant
        [config]="datagridConfig"
        [restapiService]="cpktestService"></datagrid>`
} )
export class CpktestGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public cpktestService: CpktestService ) { }

}