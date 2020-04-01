import { Component, OnInit } from '@angular/core';

import { CercadorProjectesService } from './cercadorProjectes.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="cercadorProjectesService"></bng-datagrid>`
} )
export class CercadorProjectesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public cercadorProjectesService: CercadorProjectesService ) { }

}