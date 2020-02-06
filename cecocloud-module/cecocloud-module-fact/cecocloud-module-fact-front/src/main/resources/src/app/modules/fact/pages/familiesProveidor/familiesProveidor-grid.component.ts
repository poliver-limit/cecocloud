import { Component, OnInit } from '@angular/core';

import { FamiliesProveidorService } from './familiesProveidor.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="familiesProveidorService"></bng-datagrid>`
} )
export class FamiliesProveidorGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public familiesProveidorService: FamiliesProveidorService ) { }

}