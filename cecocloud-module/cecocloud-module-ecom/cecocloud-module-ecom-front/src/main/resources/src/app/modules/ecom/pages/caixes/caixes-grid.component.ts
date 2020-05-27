import { Component, OnInit } from '@angular/core';

import { CaixesService } from './caixes.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="caixesService"></bng-datagrid>`
} )
export class CaixesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public caixesService: CaixesService ) { }

}