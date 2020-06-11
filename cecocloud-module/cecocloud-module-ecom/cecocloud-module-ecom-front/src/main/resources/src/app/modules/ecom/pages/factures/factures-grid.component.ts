import { Component, OnInit } from '@angular/core';

import { FacturesService } from './factures.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="facturesService"></bng-datagrid>`
} )
export class FacturesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public facturesService: FacturesService ) { }

}