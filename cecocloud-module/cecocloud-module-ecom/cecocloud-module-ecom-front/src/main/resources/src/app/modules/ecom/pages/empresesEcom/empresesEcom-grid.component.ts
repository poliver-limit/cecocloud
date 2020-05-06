import { Component, OnInit } from '@angular/core';

import { EmpresesEcomService } from './empresesEcom.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="empresesEcomService"></bng-datagrid>`
} )
export class EmpresesEcomGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public empresesEcomService: EmpresesEcomService ) { }

}