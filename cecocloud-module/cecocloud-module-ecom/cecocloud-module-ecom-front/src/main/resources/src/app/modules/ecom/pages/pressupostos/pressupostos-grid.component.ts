import { Component, OnInit } from '@angular/core';

import { PressupostosService } from './pressupostos.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="pressupostosService"></bng-datagrid>`
} )
export class PressupostosGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public pressupostosService: PressupostosService ) { }

}