import { Component, OnInit } from '@angular/core';

import { OperarisService } from './operaris.service';

@Component( {
    template: `
    <datagrid
        datagrid-mant
        [config]="datagridConfig"
        [restapiService]="operarisService"></datagrid>`
} )
export class OperarisGridComponent implements OnInit {

    datagridConfig = {
        // editable: true
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public operarisService: OperarisService ) { }

}