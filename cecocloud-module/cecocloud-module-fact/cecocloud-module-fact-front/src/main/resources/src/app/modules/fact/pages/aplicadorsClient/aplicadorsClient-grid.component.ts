import { Component, OnInit } from '@angular/core';

import { AplicadorsClientService } from './aplicadorsClient.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="aplicadorsClientService"></bng-datagrid>`
} )
export class AplicadorsClientGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public aplicadorsClientService: AplicadorsClientService ) { }

}