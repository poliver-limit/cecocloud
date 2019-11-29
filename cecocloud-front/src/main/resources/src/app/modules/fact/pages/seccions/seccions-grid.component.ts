import { Component, OnInit } from '@angular/core';

import { SeccionsService } from './seccions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="seccionsService"></bng-datagrid>`
} )
export class SeccionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public seccionsService: SeccionsService ) { }

}