import { Component } from '@angular/core';

import { CompanyiesService } from './companyies.service';

@Component( {
    template: `
    <datagrid
        datagrid-mant
        [config]="datagridConfig"
        [restapiService]="companyiesService"></datagrid>`
} )
export class CompanyiesGridComponent {

    datagridConfig = {
        editable: true,
        columnFiltersEnabled: true
    };

    constructor(
        public companyiesService: CompanyiesService ) { }

}