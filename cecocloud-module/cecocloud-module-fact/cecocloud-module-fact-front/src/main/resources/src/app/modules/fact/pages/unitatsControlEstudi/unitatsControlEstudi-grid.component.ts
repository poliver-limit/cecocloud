import { Component, OnInit } from '@angular/core';

import { UnitatsControlEstudiService } from './unitatsControlEstudi.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="unitatsControlEstudiService"></bng-datagrid>`
} )
export class UnitatsControlEstudiGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public unitatsControlEstudiService: UnitatsControlEstudiService ) { }

}