import { Component, OnInit } from '@angular/core';

import { CategoriesService } from './categories.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="categoriesService"></bng-datagrid>`
} )
export class CategoriesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public categoriesService: CategoriesService ) { }

}