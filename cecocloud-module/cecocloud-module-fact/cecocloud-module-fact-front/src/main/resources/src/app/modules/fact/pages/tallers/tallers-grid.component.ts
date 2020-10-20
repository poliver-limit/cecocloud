import { Component, OnInit } from '@angular/core';

import { TallersService } from './tallers.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tallersService"></bng-datagrid>`
} )
export class TallersGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tallersService: TallersService ) { }

}