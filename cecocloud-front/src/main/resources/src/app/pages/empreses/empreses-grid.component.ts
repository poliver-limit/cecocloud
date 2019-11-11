import { Component } from '@angular/core';

import { EmpresesService } from './empreses.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="empresesService"></bng-datagrid>`
} )
export class EmpresesGridComponent {

    datagridConfig = {
        /*additionalFilter: {
            "companyia.id": 1,
            nom: "*Lím*"
        }*/
        columnFiltersEnabled: true
    };

    constructor(
        public empresesService: EmpresesService ) { }

}