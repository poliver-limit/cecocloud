import { Component, OnInit } from '@angular/core';

import { MagatzemsArticleService } from './magatzemsArticle.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="magatzemsArticleService"></bng-datagrid>`
} )
export class MagatzemsArticleGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public magatzemsArticleService: MagatzemsArticleService ) { }

}