import { Component, OnInit } from '@angular/core';

import { NaturalesesPagamentCobramentService } from './naturalesesPagamentCobrament.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="naturalesesPagamentCobramentService"></bng-datagrid>`
} )
export class NaturalesesPagamentCobramentGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public naturalesesPagamentCobramentService: NaturalesesPagamentCobramentService ) { }

}