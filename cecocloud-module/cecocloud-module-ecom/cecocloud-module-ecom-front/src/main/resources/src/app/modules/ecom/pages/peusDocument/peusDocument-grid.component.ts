import { Component, OnInit } from '@angular/core';

import { PeusDocumentService } from './peusDocument.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="peusDocumentService"></bng-datagrid>`
} )
export class PeusDocumentGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public peusDocumentService: PeusDocumentService ) { }

}