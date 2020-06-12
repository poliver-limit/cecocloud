import { Component, OnInit } from '@angular/core';

import { VencimentsPagatService } from './vencimentsPagat.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="vencimentsPagatService"></bng-datagrid>`
} )
export class VencimentsPagatGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public vencimentsPagatService: VencimentsPagatService ) { }

}