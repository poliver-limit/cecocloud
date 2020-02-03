import { Component, OnInit } from '@angular/core';

import { OperarisRrhhService } from './operarisRrhh.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="operarisRrhhService"></bng-datagrid>`
} )
export class OperarisRrhhGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public operarisRrhhService: OperarisRrhhService ) { }

}