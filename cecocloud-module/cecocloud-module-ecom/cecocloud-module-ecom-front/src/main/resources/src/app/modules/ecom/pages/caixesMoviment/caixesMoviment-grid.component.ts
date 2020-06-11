import { Component, OnInit } from '@angular/core';

import { CaixesMovimentService } from './caixesMoviment.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="caixesMovimentService"></bng-datagrid>`
} )
export class CaixesMovimentGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public caixesMovimentService: CaixesMovimentService ) { }

}