import { Component, OnInit } from '@angular/core';

import { GroupsService } from './groups.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="groupsService"></bng-datagrid>`
} )
export class GroupsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public groupsService: GroupsService ) { }

}