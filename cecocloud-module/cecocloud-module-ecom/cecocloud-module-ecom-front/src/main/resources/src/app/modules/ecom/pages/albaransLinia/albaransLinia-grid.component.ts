import { Component, OnInit } from '@angular/core';

import { AlbaransLiniaService } from './albaransLinia.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="albaransLiniaService"></bng-datagrid>`
} )
export class AlbaransLiniaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public albaransLiniaService: AlbaransLiniaService ) { }

}