import { Component, OnInit } from '@angular/core';

import { ArticlesInformacioService } from './articlesInformacio.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="articlesInformacioService"></bng-datagrid>`
} )
export class ArticlesInformacioGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public articlesInformacioService: ArticlesInformacioService ) { }

}