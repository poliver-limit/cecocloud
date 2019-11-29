import { Component, OnInit } from '@angular/core';

import { ArticlesGammaService } from './articlesGamma.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="articlesGammaService"></bng-datagrid>`
} )
export class ArticlesGammaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public articlesGammaService: ArticlesGammaService ) { }

}