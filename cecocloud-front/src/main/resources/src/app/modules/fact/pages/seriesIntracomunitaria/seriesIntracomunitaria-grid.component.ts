import { Component, OnInit } from '@angular/core';

import { SeriesIntracomunitariaService } from './seriesIntracomunitaria.service';

@Component( {
    template: `
    <bng-datagrid
        bng-datagrid-mant
        [config]="datagridConfig"
        [restapiService]="seriesIntracomunitariaService"></bng-datagrid>`
} )
export class SeriesIntracomunitariaGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    constructor(
        public seriesIntracomunitariaService: SeriesIntracomunitariaService ) { }

}