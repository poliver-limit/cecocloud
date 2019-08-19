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

    private datagridConfig = {
        editable: true,
        pagination: true
    };

    constructor(
        private companyiesService: CompanyiesService ) { }

}