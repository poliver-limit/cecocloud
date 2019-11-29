import { Component, OnInit } from '@angular/core';

import { SituacionsComercialService } from './situacionsComercial.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="situacionsComercialService"></bng-datagrid>`
} )
export class SituacionsComercialGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public situacionsComercialService: SituacionsComercialService ) { }

}