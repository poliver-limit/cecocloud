import { Component, OnInit } from '@angular/core';

import { ArticlesFamiliaEmpresaService } from './articlesFamiliaEmpresa.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="articlesFamiliaEmpresaService"></bng-datagrid>`
} )
export class ArticlesFamiliaEmpresaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public articlesFamiliaEmpresaService: ArticlesFamiliaEmpresaService ) { }

}