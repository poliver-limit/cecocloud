import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { LicitacionsService } from './licitacions.service';
import { BngDatagridConfig } from '@programari-limit/base-angular';

@Component({
	template: `
	<bng-datagrid
		#datagrid
		[config]="datagridConfig"
		[restapiService]="licitacionsService"
		(rowClicked)="onRowClicked($event)"></bng-datagrid>`
})
export class LicitacionsGridComponent implements OnInit {

	datagridConfig: BngDatagridConfig = {
		//editable: true,
		resizable: true,
		columnFiltersEnabled: true,
		columns: [{
			field: 'projecteTitol',
			tooltipField: 'projecteTitol',
			width: 21
		}, {
			field: 'unitatNom',
			tooltipField: 'unitatNom',
			width: 21
		}, {
			field: 'projecteProvinciaDescripcio',
			width: 6
		}, {
			field: 'projecteImportTotal',
			width: 6
		}, {
			field: 'projecteImportSenseTaxes',
			width: 6
		}, {
			field: 'procedimentTipusDescripcio',
			width: 10
		}, {
			field: 'dataActualitzacio',
			width: 10
		}, {
			field: 'dataLimit',
			width: 10
		}, {
			field: 'expedientEstatDescripcio',
			width: 6
		}, {
			field: 'destacada',
			width: 2/*,
			cellRenderer: function(params) {
				if (params.data !== undefined) {
					var newSpan = document.createElement('span');
					if (params.data.destacat) {
						newSpan.className += 'fa fa-lg fa-star text-warning';
					} else {
						newSpan.className += 'fa fa-lg fa-star-o';
					}
					newSpan.setAttribute('style', 'cursor: pointer;');
					return newSpan;
				}
			}*/
		}],

	};

	ngOnInit() {
	}

	onRowClicked(event: any) {
		this.router.navigate(['update', event.data.id], { relativeTo: this.route });
	}

	constructor(
		private router: Router,
		private route: ActivatedRoute,
		public licitacionsService: LicitacionsService) { }

}


