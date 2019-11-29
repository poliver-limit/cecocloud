import { Component, OnInit } from '@angular/core';

import { TarifesService } from './tarifes.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tarifesService"></bng-datagrid>`
} )
export class TarifesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tarifesService: TarifesService ) { }

}