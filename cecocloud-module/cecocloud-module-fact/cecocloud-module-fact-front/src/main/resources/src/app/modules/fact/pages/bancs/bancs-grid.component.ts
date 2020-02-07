import { Component, OnInit } from '@angular/core';

import { BancsService } from './bancs.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="bancsService"></bng-datagrid>`
} )
export class BancsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public bancsService: BancsService ) { }

}