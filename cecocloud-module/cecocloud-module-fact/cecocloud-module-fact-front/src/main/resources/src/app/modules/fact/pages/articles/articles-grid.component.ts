import { Component, OnInit } from '@angular/core';

import { ArticlesService } from './articles.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="articlesService"></bng-datagrid>`
} )
export class ArticlesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public articlesService: ArticlesService ) { }

}