import { Component, OnInit } from '@angular/core';

import { ParametresService } from './parametres.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="parametresService"></bng-datagrid>`
} )
export class ParametresGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public parametresService: ParametresService ) { }

}