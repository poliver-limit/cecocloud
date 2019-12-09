import { Component, OnInit } from '@angular/core';

import { CalendarisService } from './calendaris.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="calendarisService"></bng-datagrid>`
} )
export class CalendarisGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public calendarisService: CalendarisService ) { }

}