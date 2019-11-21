import { Component, OnInit } from '@angular/core';

import { ProveidorsService } from './proveidors.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="proveidorsService"></bng-datagrid>`
} )
export class ProveidorsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public proveidorsService: ProveidorsService ) { }

}