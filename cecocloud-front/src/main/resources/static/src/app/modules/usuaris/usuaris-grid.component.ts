import { Component, OnInit } from '@angular/core';

import { UsuarisService, Usuari } from './usuaris.service';

@Component( {
    template: `
    <datagrid
        datagrid-mant
        [config]="datagridConfig"
        [restapiService]="usuarisService"></datagrid>`
} )
export class UsuarisGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public usuarisService: UsuarisService ) { }

}