import { Component, OnInit } from '@angular/core';

import { PreusPerGammaService } from './preusPerGamma.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="preusPerGammaService"></bng-datagrid>`
} )
export class PreusPerGammaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public preusPerGammaService: PreusPerGammaService ) { }

}