import { Component, OnInit } from '@angular/core';

import { RegimsIvaService } from './regimsIva.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="regimsIvaService"></bng-datagrid>`
} )
export class RegimsIvaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public regimsIvaService: RegimsIvaService ) { }

}