import { Component, OnInit } from '@angular/core';

import { SeccionsEmpresaService } from './seccionsEmpresa.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="seccionsEmpresaService"></bng-datagrid>`
} )
export class SeccionsEmpresaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public seccionsEmpresaService: SeccionsEmpresaService ) { }

}