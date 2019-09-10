import { Component, OnInit } from '@angular/core';

import { MarcatgesService } from './marcatges.service';

@Component( {
    template: `
    <datagrid
        datagrid-mant
        [config]="datagridConfig"
        [restapiService]="marcatgesService"></datagrid>`
} )
export class MarcatgesGridComponent implements OnInit {

    datagridConfig = {
        /*editable: true,*/
        columnFiltersEnabled: true,
        columns: [{
            field: 'operari',
            sort: 'asc'
        }, {
            field: 'data',
            sort: 'desc'
        }, {
            field: 'origen'
        }]
    };

    ngOnInit() {
    }

    constructor(
        public marcatgesService: MarcatgesService ) { }

}