import { Component, OnInit } from '@angular/core';

import { ProductesService } from './productes.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="productesService"></bng-datagrid>`
} )
export class ProductesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public productesService: ProductesService ) { }

}