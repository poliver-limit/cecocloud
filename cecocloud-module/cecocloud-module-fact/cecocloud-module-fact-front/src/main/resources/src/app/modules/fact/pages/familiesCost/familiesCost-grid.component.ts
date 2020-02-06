import { Component, OnInit } from '@angular/core';

import { FamiliesCostService } from './familiesCost.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="familiesCostService"></bng-datagrid>`
} )
export class FamiliesCostGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public familiesCostService: FamiliesCostService ) { }

}