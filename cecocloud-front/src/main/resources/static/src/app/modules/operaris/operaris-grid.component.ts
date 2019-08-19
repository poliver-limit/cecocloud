import { Component, OnInit } from '@angular/core';

import { OperarisService } from './operaris.service';

@Component( {
    template: `
    <datagrid
        datagrid-mant
        [config]="datagridConfig"
        [restapiService]="operarisService"></datagrid>`
} )
export class OperarisGridComponent implements OnInit {

    private datagridConfig = {
        editable: true,
        pagination: false
    };

    ngOnInit() {
    }

    constructor(
        private operarisService: OperarisService ) { }

}