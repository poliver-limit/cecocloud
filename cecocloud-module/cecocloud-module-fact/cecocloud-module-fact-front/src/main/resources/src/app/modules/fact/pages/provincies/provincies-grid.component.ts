import { Component, OnInit } from '@angular/core';

import { ProvinciesService } from './provincies.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="provinciesService"></bng-datagrid>`
} )
export class ProvinciesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public provinciesService: ProvinciesService ) { }

}