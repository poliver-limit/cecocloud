import { Component, OnInit } from '@angular/core';

import { ServidorsService } from './servidors.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="servidorsService"></bng-datagrid>`
} )
export class ServidorsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public servidorsService: ServidorsService ) { }

}