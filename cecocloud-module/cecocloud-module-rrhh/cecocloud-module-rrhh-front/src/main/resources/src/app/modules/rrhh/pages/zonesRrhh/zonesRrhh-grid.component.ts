import { Component, OnInit } from '@angular/core';

import { ZonesRrhhService } from './zonesRrhh.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="zonesRrhhService"></bng-datagrid>`
} )
export class ZonesRrhhGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public zonesRrhhService: ZonesRrhhService ) { }

}