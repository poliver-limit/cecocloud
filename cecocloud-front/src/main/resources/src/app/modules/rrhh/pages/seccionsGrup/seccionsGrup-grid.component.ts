import { Component, OnInit } from '@angular/core';

import { SeccionsGrupService } from './seccionsGrup.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="seccionsGrupService"></bng-datagrid>`
} )
export class SeccionsGrupGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public seccionsGrupService: SeccionsGrupService ) { }

}