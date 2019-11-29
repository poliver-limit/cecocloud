import { Component, OnInit } from '@angular/core';

import { UbicacionsArticleService } from './ubicacionsArticle.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="ubicacionsArticleService"></bng-datagrid>`
} )
export class UbicacionsArticleGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public ubicacionsArticleService: UbicacionsArticleService ) { }

}