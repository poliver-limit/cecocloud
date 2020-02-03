import { Component, OnInit } from '@angular/core';

import { HorarisService } from './horaris.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="horarisService"></bng-datagrid>`
} )
export class HorarisGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public horarisService: HorarisService ) { }

}