import { Component, OnInit } from '@angular/core';

import { SubvencionsService } from './subvencions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="subvencionsService"></bng-datagrid>`
} )
export class SubvencionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public subvencionsService: SubvencionsService ) { }

}