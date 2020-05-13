import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngDatagridConfig } from 'base-angular';

import { PuntsVendaService } from './puntsVenda.service';
import { PuntVendaHorarisService } from './puntVendaHoraris.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="puntsVendaService"
	(resourceLoad)="onResourceLoad($event)">
	<ng-container *ngIf="id">
		<mat-tab-group>
			<mat-tab label="{{'resource.puntVendaHorari.plural' | translate}}">
				<br/>
				<bng-datagrid
					[config]="puntVendaHorarisDatagridConfig"
					[restapiService]="puntVendaHorarisService"
					[editable]="true"></bng-datagrid>
			</mat-tab>
		</mat-tab-group>
	</ng-container>
</bng-form>
`
})
export class PuntsVendaFormComponent extends BngFormBaseComponent {

	puntVendaHorarisDatagridConfig: BngDatagridConfig = {
		mode: 'form',
		columns: [{
			field: 'horari',
		}]
	};

	onResourceLoad(puntVenda: any) {
		this.puntVendaHorarisDatagridConfig.fixedFilter = 'puntVenda.codi==' + puntVenda.codi;
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public puntsVendaService: PuntsVendaService,
		public puntVendaHorarisService: PuntVendaHorarisService) {
		super(activatedRoute);
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.puntVendaHorarisDatagridConfig.fixedRowData = {
					puntVenda: {
						id: params.id,
						description: undefined
					}
				}
			}
		});
		this.formConfig.readOnlyStateEnabled = false;
	}

}