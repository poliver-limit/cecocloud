import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngDatagridConfig } from 'base-angular';

import { AgrupacionsService } from './agrupacions.service';
import { AgrupacionsFuncionalitatsService } from './agrupacions-funcionalitats.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="agrupacionsService">
	<ng-container *ngIf="id">
		<mat-tab-group>
			<mat-tab label="{{'resource.funcionalitat.plural' | translate}}">
				<br/>
				<bng-datagrid
					[config]="funcionalitatsDatagridConfig"
					[restapiService]="agrupacionsFuncionalitatsService"
					[editable]="true"></bng-datagrid>
			</mat-tab>
		</mat-tab-group>
	</ng-container>
</bng-form>
`
})
export class AgrupacionsFormComponent extends BngFormBaseComponent {

	funcionalitatsDatagridConfig: BngDatagridConfig = {
		mode: 'form',
		columns: [{
			field: 'funcionalitat',
			width: 80
		}, {
			field: 'obligatoria',
			width: 20
		}]
	};

	constructor(
		activatedRoute: ActivatedRoute,
		public agrupacionsService: AgrupacionsService,
		public agrupacionsFuncionalitatsService: AgrupacionsFuncionalitatsService) {
		super(activatedRoute);
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.funcionalitatsDatagridConfig.fixedFilter = 'agrupacio.id==' + params.id;
				this.funcionalitatsDatagridConfig.fixedRowData = {
					agrupacio: {
						id: parseInt(params.id),
						description: undefined
					}
				}
			}
		});
		this.formConfig.readOnlyStateEnabled = false;
	}

}