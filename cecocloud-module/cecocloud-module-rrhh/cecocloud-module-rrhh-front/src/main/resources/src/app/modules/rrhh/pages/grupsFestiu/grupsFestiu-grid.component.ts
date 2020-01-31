import { Component, OnInit } from '@angular/core';

import { GrupsFestiuService } from './grupsFestiu.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="grupsFestiuService"></bng-datagrid>`
} )
export class GrupsFestiuGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public grupsFestiuService: GrupsFestiuService ) { }

}