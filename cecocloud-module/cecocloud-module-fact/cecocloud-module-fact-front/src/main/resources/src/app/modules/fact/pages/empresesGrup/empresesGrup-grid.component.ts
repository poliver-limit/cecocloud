import { Component, OnInit } from '@angular/core';

import { EmpresesGrupService } from './empresesGrup.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="empresesGrupService"></bng-datagrid>`
} )
export class EmpresesGrupGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public empresesGrupService: EmpresesGrupService ) { }

}