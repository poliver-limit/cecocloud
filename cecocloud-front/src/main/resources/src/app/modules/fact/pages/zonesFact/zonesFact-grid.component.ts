import { Component, OnInit } from '@angular/core';

import { ZonesFactService } from './zonesFact.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="zonesFactService"></bng-datagrid>`
} )
export class ZonesFactGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public zonesFactService: ZonesFactService ) { }

}