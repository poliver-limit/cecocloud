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
    [restapiService]="operarisService"
	(resourceLoad)="onResourceLoad($event)">
	<!--h2 *ngIf="operari" class="mat-display-1" style="margin-bottom:16px">
		{{operari.codi}}<br/>
	</h2-->
	<mat-card *ngIf="operari">
		<mat-card-header>
			<ng-container mat-card-avatar>
				<button mat-icon-button><mat-icon style="font-size:50px;width:50px">account_circle</mat-icon></button>
			</ng-container>
			<mat-card-title>{{operari.description}}</mat-card-title>
			<mat-card-subtitle>{{operari.usuariEmail}}</mat-card-subtitle>
		</mat-card-header>
	</mat-card>
	<!--div style="display: flex">
		<bng-custom-field name="codi" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="usuari" style="width: 50%"></bng-custom-field>
	</div-->
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

	operari: any;
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

	onResourceLoad(operari: any) {
		this.operari = operari;
	}

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