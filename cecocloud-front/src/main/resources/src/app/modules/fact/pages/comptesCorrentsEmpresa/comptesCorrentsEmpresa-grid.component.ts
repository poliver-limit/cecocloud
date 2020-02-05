import { Component, OnInit } from '@angular/core';

import { ComptesCorrentsEmpresaService } from './comptesCorrentsEmpresa.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="comptesCorrentsEmpresaService"></bng-datagrid>`
} )
export class ComptesCorrentsEmpresaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public comptesCorrentsEmpresaService: ComptesCorrentsEmpresaService ) { }

}