import { Component, OnInit } from '@angular/core';

import { ArticlesMarcaService } from './articlesMarca.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="articlesMarcaService"></bng-datagrid>`
} )
export class ArticlesMarcaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public articlesMarcaService: ArticlesMarcaService ) { }

}