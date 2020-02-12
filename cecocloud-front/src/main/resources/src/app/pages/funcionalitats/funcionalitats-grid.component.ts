import { Component } from '@angular/core';
import { BngDatagridConfig } from 'base-angular';

import { FuncionalitatsService } from './funcionalitats.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="funcionalitatsService"></bng-datagrid>`
} )
export class FuncionalitatsGridComponent {

    datagridConfig: BngDatagridConfig = {
        columnFiltersEnabled: true
    };

    constructor(public funcionalitatsService: FuncionalitatsService) { }

}