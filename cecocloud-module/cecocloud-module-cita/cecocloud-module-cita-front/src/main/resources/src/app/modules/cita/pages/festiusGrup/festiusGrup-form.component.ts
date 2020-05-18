import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngDatagridConfig } from 'base-angular';

import { FestiusGrupService } from './festiusGrup.service';
import { FestiusService } from './festius.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="festiusGrupService"
	(resourceLoad)="onResourceLoad($event)">
	<ng-container *ngIf="id">
		<mat-tab-group>
			<mat-tab label="{{'resource.festiu.plural' | translate}}">
				<br/>
				<bng-datagrid
					*ngIf="showGrid"
					[config]="festiusDatagridConfig"
					[restapiService]="festiusService"
					[editable]="true"></bng-datagrid>
			</mat-tab>
		</mat-tab-group>
	</ng-container>
</bng-form>
`
})
export class FestiusGrupFormComponent extends BngFormBaseComponent {

	showGrid: boolean;

	festiusDatagridConfig: BngDatagridConfig = {
		mode: 'form',
		columns: [{
			field: 'nom',
			width: 40
		}, {
			field: 'diaMes',
			width: 30
		}, {
			field: 'any',
			width: 30
		}]
	};

	onResourceLoad(festiuGrup: any) {
		this.festiusDatagridConfig.fixedFilter = 'festiuGrup.codi==' + festiuGrup.codi;
		this.showGrid = true;
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public festiusGrupService: FestiusGrupService,
		public festiusService: FestiusService) {
		super(activatedRoute);
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.festiusDatagridConfig.fixedRowData = {
					festiuGrup: {
						id: params.id,
						description: undefined
					}
				}
			}
		});
		this.formConfig.readOnlyStateEnabled = false;
	}

}