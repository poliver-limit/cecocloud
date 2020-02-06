import { Component, OnInit } from '@angular/core';

import { DocumentsPagamentCobramentService } from './documentsPagamentCobrament.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="documentsPagamentCobramentService"></bng-datagrid>`
} )
export class DocumentsPagamentCobramentGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public documentsPagamentCobramentService: DocumentsPagamentCobramentService ) { }

}