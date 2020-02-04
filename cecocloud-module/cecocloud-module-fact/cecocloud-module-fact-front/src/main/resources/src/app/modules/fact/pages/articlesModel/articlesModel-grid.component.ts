import { Component, OnInit } from '@angular/core';

import { ArticlesModelService } from './articlesModel.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="articlesModelService"></bng-datagrid>`
} )
export class ArticlesModelGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public articlesModelService: ArticlesModelService ) { }

}