import { Component, OnInit } from '@angular/core';

import { AlbaransService } from './albarans.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="albaransService"></bng-datagrid>`
} )
export class AlbaransGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public albaransService: AlbaransService ) { }

}