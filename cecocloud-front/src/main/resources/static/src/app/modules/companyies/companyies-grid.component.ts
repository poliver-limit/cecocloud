import { Component } from '@angular/core';

import { CompanyiesService } from './companyies.service';

@Component( {
    template: `
    <bng-datagrid
        datagrid-mant
        [config]="datagridConfig"
        [restapiService]="companyiesService"></bng-datagrid>`
} )
export class CompanyiesGridComponent {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true,
        paginationEnabled: false
    };

    constructor(
        public companyiesService: CompanyiesService ) { }

}