import { Component, OnInit } from '@angular/core';

import { PaisosService } from './paisos.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="paisosService"></bng-datagrid>`
} )
export class PaisosGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public paisosService: PaisosService ) { }

}