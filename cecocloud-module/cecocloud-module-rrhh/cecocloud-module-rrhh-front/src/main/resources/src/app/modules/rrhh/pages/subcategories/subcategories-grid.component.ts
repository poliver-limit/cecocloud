import { Component, OnInit } from '@angular/core';

import { SubcategoriesService } from './subcategories.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="subcategoriesService"></bng-datagrid>`
} )
export class SubcategoriesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public subcategoriesService: SubcategoriesService ) { }

}