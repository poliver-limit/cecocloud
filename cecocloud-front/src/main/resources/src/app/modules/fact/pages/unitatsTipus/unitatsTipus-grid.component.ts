import { Component, OnInit } from '@angular/core';

import { UnitatsTipusService } from './unitatsTipus.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="unitatsTipusService"></bng-datagrid>`
} )
export class UnitatsTipusGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public unitatsTipusService: UnitatsTipusService ) { }

}