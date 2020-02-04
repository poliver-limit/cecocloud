import { Component, OnInit } from '@angular/core';

import { ArticlesFamiliaService } from './articlesFamilia.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="articlesFamiliaService"></bng-datagrid>`
} )
export class ArticlesFamiliaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public articlesFamiliaService: ArticlesFamiliaService ) { }

}