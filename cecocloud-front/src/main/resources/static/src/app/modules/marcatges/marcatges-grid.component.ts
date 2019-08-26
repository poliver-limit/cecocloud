import { Component, OnInit } from '@angular/core';

import { MarcatgesService } from './marcatges.service';

@Component( {
    template: `
    <datagrid
        datagrid-mant
        [config]="datagridConfig"
        [restapiService]="marcatgesService"></datagrid>`
} )
export class MarcatgesGridComponent implements OnInit {

    private datagridConfig = {
        editable: true,
        filterInEachColumn: true
    };

    ngOnInit() {
    }

    constructor(
        private marcatgesService: MarcatgesService ) { }

}