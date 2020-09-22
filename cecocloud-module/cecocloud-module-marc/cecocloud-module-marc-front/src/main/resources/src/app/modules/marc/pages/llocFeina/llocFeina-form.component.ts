import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngDatagridConfig } from 'base-angular';

import { LlocFeinaService } from './llocFeina.service';
import { OperariEmpresaLlocFeinaService } from './operariEmpresaLlocFeina.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="llocFeinaService"
	(resourceLoad)="onResourceLoad($event)">
	<ng-container *ngIf="id">
		<mat-tab-group>
			<mat-tab label="{{'resource.operariEmpresaLlocFeina.plural' | translate}}">
				<br/>
				<bng-datagrid
					*ngIf="showGrid"
					[config]="operariEmpresaLlocFeinaDatagridConfig"
					[restapiService]="operariEmpresaLlocFeinaService"
					[editable]="true"></bng-datagrid>
			</mat-tab>
		</mat-tab-group>
	</ng-container>
</bng-form>
`
})
export class LlocFeinaFormComponent extends BngFormBaseComponent {

	showGrid: boolean;

	operariEmpresaLlocFeinaDatagridConfig: BngDatagridConfig = {
		mode: 'form',
		columns: [{
			field: 'operariEmpresa',
			width: 100
		}]
	};

	onResourceLoad(llocFeina: any) {
		this.operariEmpresaLlocFeinaDatagridConfig.fixedFilter = 'llocFeina.id==' + llocFeina.id;
		this.showGrid = true;
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public llocFeinaService: LlocFeinaService,
		public operariEmpresaLlocFeinaService: OperariEmpresaLlocFeinaService) {
		super(activatedRoute);
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.operariEmpresaLlocFeinaDatagridConfig.fixedRowData = {
					llocFeina: {
						id: params.id,
						description: undefined
					}
				}
			}
		});
		this.formConfig.readOnlyStateEnabled = false;
	}

}