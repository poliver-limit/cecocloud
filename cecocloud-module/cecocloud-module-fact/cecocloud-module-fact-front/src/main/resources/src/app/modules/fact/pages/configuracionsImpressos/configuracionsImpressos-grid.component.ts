import { Component, OnInit } from '@angular/core';

import { ConfiguracionsImpressosService } from './configuracionsImpressos.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="configuracionsImpressosService"></bng-datagrid>`
} )
export class ConfiguracionsImpressosGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public configuracionsImpressosService: ConfiguracionsImpressosService ) { }

}