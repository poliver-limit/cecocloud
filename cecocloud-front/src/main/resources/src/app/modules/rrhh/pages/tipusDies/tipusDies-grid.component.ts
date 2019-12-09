import { Component, OnInit } from '@angular/core';

import { TipusDiesService } from './tipusDies.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tipusDiesService"></bng-datagrid>`
} )
export class TipusDiesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tipusDiesService: TipusDiesService ) { }

}