import { Component } from '@angular/core';
import { BngDatagridConfig } from 'base-angular';

import { RecursosService } from './recursos.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="recursosService"></bng-datagrid>`
} )
export class RecursosGridComponent {

    datagridConfig: BngDatagridConfig = {
        columnFiltersEnabled: true,

    };

    constructor( public recursosService: RecursosService) { }

}