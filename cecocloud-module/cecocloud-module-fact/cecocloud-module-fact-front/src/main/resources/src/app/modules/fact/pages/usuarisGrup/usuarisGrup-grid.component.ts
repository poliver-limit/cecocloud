import { Component, OnInit } from '@angular/core';

import { UsuarisGrupService } from './usuarisGrup.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="usuarisGrupService"></bng-datagrid>`
} )
export class UsuarisGrupGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public usuarisGrupService: UsuarisGrupService ) { }

}