import { Component, OnInit } from '@angular/core';

import { ParametersService } from './parameters.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="parametersService"></bng-datagrid>`
} )
export class ParametersGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public parametersService: ParametersService ) { }

}