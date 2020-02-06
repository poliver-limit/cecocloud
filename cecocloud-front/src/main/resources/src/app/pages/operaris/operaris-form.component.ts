import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngDatagridConfig } from 'base-angular';

import { OperarisService } from './operaris.service';
import { OperarisEmpresesService } from './operaris-empreses.service';

@Component({
	template: `
<bng-form
    bng-form-mant
    [config]="formConfig"
    [restapiService]="operarisService">
	<div style="display: flex">
		<bng-custom-field name="codi" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="usuari" style="width: 50%"></bng-custom-field>
	</div>
	<bng-custom-field name="actiu"></bng-custom-field>
	<ng-container *ngIf="id">
		<mat-tab-group>
			<mat-tab label="{{'resource.empresa.plural' | translate}}">
				<br/>
				<bng-datagrid
					[config]="empresesDatagridConfig"
					[restapiService]="operarisEmpresesService"
					[editable]="true"></bng-datagrid>
			</mat-tab>
		</mat-tab-group>
	</ng-container>
</bng-form>
`
})
export class OperarisFormComponent extends BngFormBaseComponent {

	empresesDatagridConfig: BngDatagridConfig = {
		mode: 'form',
		columns: [{
			field: 'empresa',
			width: 80
		}, {
			field: 'actiu',
			width: 20
		}]
	};

	constructor(
		activatedRoute: ActivatedRoute,
		public operarisService: OperarisService,
		public operarisEmpresesService: OperarisEmpresesService) {
		super(activatedRoute);
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.empresesDatagridConfig.fixedFilter = 'operari.id==' + params.id;
				this.empresesDatagridConfig.fixedRowData = {
					operari: {
						id: params.id,
						description: undefined
					}
				}
			}
		});
		this.formConfig.readOnlyStateEnabled = false;
	}

}