import { Component, OnInit } from '@angular/core';

import { LiniesEstudiService } from './liniesEstudi.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="liniesEstudiService"></bng-datagrid>`
} )
export class LiniesEstudiGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public liniesEstudiService: LiniesEstudiService ) { }

}