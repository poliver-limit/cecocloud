import { Component, OnInit } from '@angular/core';

import { MantenimentsDeTipusService } from './mantenimentsDeTipus.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="mantenimentsDeTipusService"></bng-datagrid>`
} )
export class MantenimentsDeTipusGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public mantenimentsDeTipusService: MantenimentsDeTipusService ) { }

}