import { Component, OnInit } from '@angular/core';

import { ProveidorsVencimentService } from './proveidorsVenciment.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="proveidorsVencimentService"></bng-datagrid>`
} )
export class ProveidorsVencimentGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public proveidorsVencimentService: ProveidorsVencimentService ) { }

}