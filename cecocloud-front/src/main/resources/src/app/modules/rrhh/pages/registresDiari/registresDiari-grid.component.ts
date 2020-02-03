import { Component, OnInit } from '@angular/core';

import { RegistresDiariService } from './registresDiari.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="registresDiariService"></bng-datagrid>`
} )
export class RegistresDiariGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public registresDiariService: RegistresDiariService ) { }

}