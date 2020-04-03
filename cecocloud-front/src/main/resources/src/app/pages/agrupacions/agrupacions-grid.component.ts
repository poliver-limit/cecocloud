import { Component } from '@angular/core';
import { BngDatagridConfig } from 'base-angular';

import { AgrupacionsService } from './agrupacions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="agrupacionsService"></bng-datagrid>`
} )
export class AgrupacionsGridComponent {

    datagridConfig: BngDatagridConfig = {
        columnFiltersEnabled: true
    };

    constructor(public agrupacionsService: AgrupacionsService) { }

}