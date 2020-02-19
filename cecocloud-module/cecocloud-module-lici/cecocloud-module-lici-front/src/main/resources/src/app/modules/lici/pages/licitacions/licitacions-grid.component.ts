import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { LicitacionsService } from './licitacions.service';

@Component( {
    template: `
    <bng-datagrid
        #datagrid
        [config]="datagridConfig"
        [restapiService]="licitacionsService"
        (rowClicked)="onRowClicked($event)"></bng-datagrid>`
} )
export class LicitacionsGridComponent implements OnInit {

    datagridConfig = {
        //editable: true,
        columnFiltersEnabled: true
    };

    ngOnInit() {
    }

    onRowClicked(event: any) {
		this.router.navigate(['update', event.data.id], { relativeTo: this.route });
	}

    constructor(
        private router: Router,
        private route: ActivatedRoute,
        public licitacionsService: LicitacionsService ) { }

}