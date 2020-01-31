import { Component, OnInit } from '@angular/core';

import { IdiomesService } from './idiomes.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="idiomesService"></bng-datagrid>`
} )
export class IdiomesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public idiomesService: IdiomesService ) { }

}