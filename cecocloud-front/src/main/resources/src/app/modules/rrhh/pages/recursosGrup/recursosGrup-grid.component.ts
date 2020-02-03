import { Component, OnInit } from '@angular/core';

import { RecursosGrupService } from './recursosGrup.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="recursosGrupService"></bng-datagrid>`
} )
export class RecursosGrupGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public recursosGrupService: RecursosGrupService ) { }

}