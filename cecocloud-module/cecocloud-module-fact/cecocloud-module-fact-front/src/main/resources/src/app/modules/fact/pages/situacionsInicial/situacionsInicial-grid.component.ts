import { Component, OnInit } from '@angular/core';

import { SituacionsInicialService } from './situacionsInicial.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="situacionsInicialService"></bng-datagrid>`
} )
export class SituacionsInicialGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public situacionsInicialService: SituacionsInicialService ) { }

}