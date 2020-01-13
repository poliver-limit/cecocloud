import { Component, OnInit } from '@angular/core';

import { TipusComissionsService } from './tipusComissions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tipusComissionsService"></bng-datagrid>`
} )
export class TipusComissionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tipusComissionsService: TipusComissionsService ) { }

}