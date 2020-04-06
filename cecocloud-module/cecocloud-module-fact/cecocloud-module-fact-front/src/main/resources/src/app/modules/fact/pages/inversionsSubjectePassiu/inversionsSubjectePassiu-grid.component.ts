import { Component, OnInit } from '@angular/core';

import { InversionsSubjectePassiuService } from './inversionsSubjectePassiu.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="inversionsSubjectePassiuService"></bng-datagrid>`
} )
export class InversionsSubjectePassiuGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public inversionsSubjectePassiuService: InversionsSubjectePassiuService ) { }

}