import { Component, OnInit } from '@angular/core';

import { AplicadorsService } from './aplicadors.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="aplicadorsService"></bng-datagrid>`
} )
export class AplicadorsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public aplicadorsService: AplicadorsService ) { }

}