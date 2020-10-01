import { Component, OnInit } from '@angular/core';

import { CategoriesTraduccioService } from './categoriesTraduccio.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="categoriesTraduccioService"></bng-datagrid>`
} )
export class CategoriesTraduccioGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public categoriesTraduccioService: CategoriesTraduccioService ) { }

}