import { Component, OnInit } from '@angular/core';

import { ArticlesTraduccioService } from './articlesTraduccio.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="articlesTraduccioService"></bng-datagrid>`
} )
export class ArticlesTraduccioGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public articlesTraduccioService: ArticlesTraduccioService ) { }

}