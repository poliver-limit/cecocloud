import { Component, OnInit } from '@angular/core';

import { IntervalsService } from './intervals.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="intervalsService"></bng-datagrid>`
} )
export class IntervalsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public intervalsService: IntervalsService ) { }

}