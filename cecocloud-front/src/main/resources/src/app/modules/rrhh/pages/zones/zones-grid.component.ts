import { Component, OnInit } from '@angular/core';

import { ZonesService } from './zones.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="zonesService"></bng-datagrid>`
} )
export class ZonesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public zonesService: ZonesService ) { }

}