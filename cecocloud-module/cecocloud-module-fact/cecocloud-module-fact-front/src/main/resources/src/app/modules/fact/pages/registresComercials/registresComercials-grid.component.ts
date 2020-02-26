import { Component, OnInit } from '@angular/core';

import { RegistresComercialsService } from './registresComercials.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="registresComercialsService"></bng-datagrid>`
} )
export class RegistresComercialsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public registresComercialsService: RegistresComercialsService ) { }

}