import { Component, OnInit } from '@angular/core';

import { EstudisProjecteService } from './estudisProjecte.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="estudisProjecteService"></bng-datagrid>`
} )
export class EstudisProjecteGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public estudisProjecteService: EstudisProjecteService ) { }

}