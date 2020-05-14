import { Component } from '@angular/core';
import { BngDatagridConfig } from 'base-angular';

import { ApikeysService } from './apikeys.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="apikeysService"></bng-datagrid>`
} )
export class ApikeysGridComponent {

    datagridConfig: BngDatagridConfig = {
        columnFiltersEnabled: true,
    };

    constructor( public apikeysService: ApikeysService) { }

}