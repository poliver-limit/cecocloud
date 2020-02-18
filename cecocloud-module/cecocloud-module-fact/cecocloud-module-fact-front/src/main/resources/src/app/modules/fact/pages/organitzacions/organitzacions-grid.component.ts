import { Component, OnInit } from '@angular/core';

import { OrganitzacionsService } from './organitzacions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="organitzacionsService"></bng-datagrid>`
} )
export class OrganitzacionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public organitzacionsService: OrganitzacionsService ) { }

}