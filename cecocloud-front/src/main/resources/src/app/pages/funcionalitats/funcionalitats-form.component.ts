import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngDatagridConfig } from 'base-angular';

import { FuncionalitatsService } from './funcionalitats.service';
import { FuncionalitatsRecursosService } from './funcionalitats-recursos.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="funcionalitatsService">
	<ng-container *ngIf="id">
		<mat-tab-group>
			<mat-tab label="{{'resource.recurs.plural' | translate}}">
				<br/>
				<bng-datagrid
					[config]="recursosDatagridConfig"
					[restapiService]="funcionalitatsRecursosService"
					[editable]="true"></bng-datagrid>
			</mat-tab>
		</mat-tab-group>
	</ng-container>
</bng-form>
`
})
export class FuncionalitatsFormComponent extends BngFormBaseComponent {

	recursosDatagridConfig: BngDatagridConfig = {
		mode: 'form',
		columns: [{
			field: 'recurs',
			width: 80
		}, {
			field: 'principal',
			width: 20
		}]
	};

	constructor(
		activatedRoute: ActivatedRoute,
		public funcionalitatsService: FuncionalitatsService,
		public funcionalitatsRecursosService: FuncionalitatsRecursosService) {
		super(activatedRoute);
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.recursosDatagridConfig.fixedFilter = 'funcionalitat.id==' + params.id;
				this.recursosDatagridConfig.fixedRowData = {
					funcionalitat: {
						id: parseInt(params.id),
						description: undefined
					}
				}
			}
		});
		this.formConfig.readOnlyStateEnabled = false;
	}

}