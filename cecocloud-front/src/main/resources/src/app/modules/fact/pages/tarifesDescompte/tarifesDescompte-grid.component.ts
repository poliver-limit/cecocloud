import { Component, OnInit } from '@angular/core';

import { TarifesDescompteService } from './tarifesDescompte.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tarifesDescompteService"></bng-datagrid>`
} )
export class TarifesDescompteGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tarifesDescompteService: TarifesDescompteService ) { }

}