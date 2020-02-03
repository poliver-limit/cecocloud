import { Component, OnInit } from '@angular/core';

import { FinalFacturesService } from './finalFactures.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="finalFacturesService"></bng-datagrid>`
} )
export class FinalFacturesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public finalFacturesService: FinalFacturesService ) { }

}