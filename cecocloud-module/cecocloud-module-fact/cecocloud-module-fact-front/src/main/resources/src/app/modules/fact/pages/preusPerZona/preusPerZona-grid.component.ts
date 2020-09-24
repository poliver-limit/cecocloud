import { Component, OnInit } from '@angular/core';

import { PreusPerZonaService } from './preusPerZona.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="preusPerZonaService"></bng-datagrid>`
} )
export class PreusPerZonaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public preusPerZonaService: PreusPerZonaService ) { }

}