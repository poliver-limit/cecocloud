import { Component, OnInit } from '@angular/core';

import { FamiliesClientService } from './familiesClient.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="familiesClientService"></bng-datagrid>`
} )
export class FamiliesClientGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public familiesClientService: FamiliesClientService ) { }

}