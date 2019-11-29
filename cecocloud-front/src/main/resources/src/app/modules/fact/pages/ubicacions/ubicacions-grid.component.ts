import { Component, OnInit } from '@angular/core';

import { UbicacionsService } from './ubicacions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="ubicacionsService"></bng-datagrid>`
} )
export class UbicacionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public ubicacionsService: UbicacionsService ) { }

}