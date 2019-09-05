import { Component } from '@angular/core';

import { EmpresesService } from './empreses.service';

@Component( {
    template: `
    <datagrid
        datagrid-mant
        [config]="datagridConfig"
        [restapiService]="empresesService"></datagrid>`
} )
export class EmpresesGridComponent {

    datagridConfig = {
        /*additionalFilter: {
            "companyia.id": 1,
            nom: "*Lím*"
        }*/
    };

    constructor(
        public empresesService: EmpresesService ) { }

}