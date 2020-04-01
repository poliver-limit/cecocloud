import { Component, OnInit } from '@angular/core';

import { TornsService } from './torns.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="tornsService"></bng-datagrid>`
} )
export class TornsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public tornsService: TornsService ) { }

}