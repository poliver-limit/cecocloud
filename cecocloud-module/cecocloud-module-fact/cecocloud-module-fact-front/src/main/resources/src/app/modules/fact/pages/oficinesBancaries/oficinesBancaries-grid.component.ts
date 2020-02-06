import { Component, OnInit } from '@angular/core';

import { OficinesBancariesService } from './oficinesBancaries.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="oficinesBancariesService"></bng-datagrid>`
} )
export class OficinesBancariesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public oficinesBancariesService: OficinesBancariesService ) { }

}