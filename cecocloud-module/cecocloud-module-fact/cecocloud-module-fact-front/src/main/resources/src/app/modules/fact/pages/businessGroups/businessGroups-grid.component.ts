import { Component, OnInit } from '@angular/core';

import { BusinessGroupsService } from './businessGroups.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="businessGroupsService"></bng-datagrid>`
} )
export class BusinessGroupsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public businessGroupsService: BusinessGroupsService ) { }

}