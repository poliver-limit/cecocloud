import { Component } from '@angular/core';

import { EmpresesService } from './empreses.service';

@Component( {
    template: `
    <datagrid
        datagrid-mant
        [config]="datagridConfig"
        [restapiService]="empresesService"></datagrid>`
} )
export class EmpresesGridComponent {

    private datagridConfig = {
    };

    constructor(
        private empresesService: EmpresesService ) { }

}