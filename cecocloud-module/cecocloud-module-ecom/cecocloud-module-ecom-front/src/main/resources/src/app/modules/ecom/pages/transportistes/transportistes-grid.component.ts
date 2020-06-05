import { Component, OnInit } from '@angular/core';

import { TransportistesService } from './transportistes.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="transportistesService"></bng-datagrid>`
} )
export class TransportistesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public transportistesService: TransportistesService ) { }

}