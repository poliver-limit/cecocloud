import { Component, OnInit } from '@angular/core';

import { ComptesComptablesEmpresaService } from './comptesComptablesEmpresa.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="comptesComptablesEmpresaService"></bng-datagrid>`
} )
export class ComptesComptablesEmpresaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public comptesComptablesEmpresaService: ComptesComptablesEmpresaService ) { }

}