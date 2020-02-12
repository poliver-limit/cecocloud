import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngDatagridConfig } from 'base-angular';

import { OperarisService } from './operaris.service';
import { OperarisEmpresesService } from './operaris-empreses.service';
import { UsuarisService } from './usuaris.service';

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
	<mat-card *ngIf="usuari">
		<mat-card-header>
			<ng-container mat-card-avatar>
				<button mat-icon-button><mat-icon style="font-size:50px;width:50px">account_circle</mat-icon></button>
			</ng-container>
			<mat-card-title>{{operari.codi}} - {{usuari.llinatges}}, {{usuari.nom}}</mat-card-title>
			<mat-card-subtitle>{{usuari.email}}</mat-card-subtitle>
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
	usuari: any;
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
		this.usuarisService.whenReady().subscribe(() => {
			this.usuarisService.get(this.operari.usuari.id).subscribe((usuari: any) => {
				this.usuari = usuari;
			});
		});
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public operarisService: OperarisService,
		public operarisEmpresesService: OperarisEmpresesService,
		public usuarisService: UsuarisService) {
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