import { Component, OnInit } from '@angular/core';

import { FacturesBaseService } from './facturesBase.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="facturesBaseService"></bng-datagrid>`
} )
export class FacturesBaseGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public facturesBaseService: FacturesBaseService ) { }

}