import { Component, OnInit } from '@angular/core';

import { EmpresesGrupEmpresesService } from './empresesGrupEmpreses.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="empresesGrupEmpresesService"></bng-datagrid>`
} )
export class EmpresesGrupEmpresesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public empresesGrupEmpresesService: EmpresesGrupEmpresesService ) { }

}