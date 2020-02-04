import { Component, OnInit } from '@angular/core';

import { IvesService } from './ives.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="ivesService"></bng-datagrid>`
} )
export class IvesGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public ivesService: IvesService ) { }

}