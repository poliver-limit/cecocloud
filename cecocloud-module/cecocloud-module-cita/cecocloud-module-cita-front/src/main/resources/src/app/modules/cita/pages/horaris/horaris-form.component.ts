import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngDatagridConfig } from 'base-angular';

import { HorarisService } from './horaris.service';
import { HorariIntervalsService } from './horariIntervals.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="horarisService"
	(resourceLoad)="onResourceLoad($event)">
	<ng-container *ngIf="id">
		<mat-tab-group>
			<mat-tab label="{{'resource.horariInterval.plural' | translate}}">
				<br/>
				<bng-datagrid
					[config]="horariIntervalsDatagridConfig"
					[restapiService]="horariIntervalsService"
					[editable]="true"></bng-datagrid>
			</mat-tab>
		</mat-tab-group>
	</ng-container>
</bng-form>
`
})
export class HorarisFormComponent extends BngFormBaseComponent {

	horariIntervalsDatagridConfig: BngDatagridConfig = {
		mode: 'form',
		columns: [{
			field: 'diaSetmana',
			width: 40
		}, {
			field: 'horaInici',
			width: 30
		}, {
			field: 'horaFi',
			width: 30
		}]
	};

	onResourceLoad(horari: any) {
		this.horariIntervalsDatagridConfig.fixedFilter = 'horari.codi==' + horari.codi;
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public horarisService: HorarisService,
		public horariIntervalsService: HorariIntervalsService) {
		super(activatedRoute);
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.horariIntervalsDatagridConfig.fixedRowData = {
					horari: {
						id: params.id,
						description: undefined
					}
				}
			}
		});
		this.formConfig.readOnlyStateEnabled = false;
	}

}