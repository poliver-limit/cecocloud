import { Component, OnInit } from '@angular/core';

import { IdentificadorsRrhhService } from './identificadorsRrhh.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="identificadorsRrhhService"></bng-datagrid>`
} )
export class IdentificadorsRrhhGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public identificadorsRrhhService: IdentificadorsRrhhService ) { }

}