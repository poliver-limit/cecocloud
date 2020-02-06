import { Component, OnInit } from '@angular/core';

import { AreaNegocisService } from './areaNegocis.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="areaNegocisService"></bng-datagrid>`
} )
export class AreaNegocisGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public areaNegocisService: AreaNegocisService ) { }

}