import { Component, OnInit } from '@angular/core';

import { LiniesFullFeinaService } from './liniesFullFeina.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="liniesFullFeinaService"></bng-datagrid>`
} )
export class LiniesFullFeinaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public liniesFullFeinaService: LiniesFullFeinaService ) { }

}