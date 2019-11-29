import { Component, OnInit } from '@angular/core';

import { TipusProveidorsClientService } from './tipusProveidorsClient.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tipusProveidorsClientService"></bng-datagrid>`
} )
export class TipusProveidorsClientGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tipusProveidorsClientService: TipusProveidorsClientService ) { }

}