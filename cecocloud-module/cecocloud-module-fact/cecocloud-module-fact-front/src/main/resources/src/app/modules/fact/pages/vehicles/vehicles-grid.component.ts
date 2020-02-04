import { Component, OnInit } from '@angular/core';

import { VehiclesService } from './vehicles.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="vehiclesService"></bng-datagrid>`
} )
export class VehiclesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public vehiclesService: VehiclesService ) { }

}