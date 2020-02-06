import { Component, OnInit } from '@angular/core';

import { CodisPostalService } from './codisPostal.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="codisPostalService"></bng-datagrid>`
} )
export class CodisPostalGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public codisPostalService: CodisPostalService ) { }

}