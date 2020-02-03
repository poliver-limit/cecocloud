import { Component, OnInit } from '@angular/core';

import { EmpresesRrhhService } from './empresesRrhh.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="empresesRrhhService"></bng-datagrid>`
} )
export class EmpresesRrhhGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public empresesRrhhService: EmpresesRrhhService ) { }

}