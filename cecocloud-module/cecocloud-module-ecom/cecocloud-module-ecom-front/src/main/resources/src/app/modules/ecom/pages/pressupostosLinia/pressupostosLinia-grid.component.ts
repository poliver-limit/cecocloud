import { Component, OnInit } from '@angular/core';

import { PressupostosLiniaService } from './pressupostosLinia.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="pressupostosLiniaService"></bng-datagrid>`
} )
export class PressupostosLiniaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public pressupostosLiniaService: PressupostosLiniaService ) { }

}