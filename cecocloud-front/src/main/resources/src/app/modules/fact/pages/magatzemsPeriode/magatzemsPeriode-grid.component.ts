import { Component, OnInit } from '@angular/core';

import { MagatzemsPeriodeService } from './magatzemsPeriode.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="magatzemsPeriodeService"></bng-datagrid>`
} )
export class MagatzemsPeriodeGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public magatzemsPeriodeService: MagatzemsPeriodeService ) { }

}