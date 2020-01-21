import { Component, OnInit } from '@angular/core';

import { PaisosNifService } from './paisosNif.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="paisosNifService"></bng-datagrid>`
} )
export class PaisosNifGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public paisosNifService: PaisosNifService ) { }

}