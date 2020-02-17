import { Component, OnInit } from '@angular/core';

import { ClassesRetencionsService } from './classesRetencions.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="classesRetencionsService"></bng-datagrid>`
} )
export class ClassesRetencionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public classesRetencionsService: ClassesRetencionsService ) { }

}