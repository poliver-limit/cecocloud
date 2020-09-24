import { Component, OnInit } from '@angular/core';

import { AltresAplicacionsService } from './altresAplicacions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="altresAplicacionsService"></bng-datagrid>`
} )
export class AltresAplicacionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public altresAplicacionsService: AltresAplicacionsService ) { }

}