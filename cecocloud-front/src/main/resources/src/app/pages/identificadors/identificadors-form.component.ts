import { IdentificadorsPermissionService } from './identificadors-permission.service';
import { Component } from '@angular/core';
import { BngFormBaseComponent, BngUsuarisForm } from 'base-angular';

import { IdentificadorsService } from './identificadors.service';
import { ActivatedRoute } from '@angular/router';

@Component({
	template: `
<bng-form
	bng-form-mant
	[id]="id"
	[config]="formConfig"
	[restapiService]="identificadorsService"
	(readonlyStateChange)="onReadonlyStateChange($event)">
	<div style="display: flex">
		<bng-custom-field name="codi" style="width: 30%; padding-right: 2em"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="descripcio" style="width: 100%"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="propietari" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<div style="width: 50%; display: flex">
			<bng-custom-field name="numUsuaris" style="width: 33.3%; padding-right: 1em"></bng-custom-field>
			<bng-custom-field name="numEmpreses" style="width: 33.3%; padding-right: 1em"></bng-custom-field>
			<bng-custom-field name="numOperaris" style="width: 33.3%"></bng-custom-field>
		</div>
	</div>
	<div style="display: flex">
		<bng-custom-field name="dataInici" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="dataFi" style="width: 50%"></bng-custom-field>
	</div>
	<ng-container *ngIf="id">
		<mat-tab-group>
			<mat-tab label="Permisos">
				<br/>
				<bng-datagrid
					[config]="permisosDatagridConfig"
					[restapiService]="identificadorsPermissionService"
					[editable]="permisosEditable"></bng-datagrid>
			</mat-tab>
		</mat-tab-group>
	</ng-container>
</bng-form>`
})
export class IdentificadorsFormComponent extends BngFormBaseComponent {

	permisosEditable: boolean;

	permisosDatagridConfig = {
		adjustHeight: false,
		paginationEnabled: false,
		mode: 'form',
		editable: true,
		columns: [{
			field: 'sidName',
			width: 60
		}, {
			field: 'adminGranted',
			width: 20
		}, {
			field: 'syncGranted',
			width: 20
		}]
	};

	onReadonlyStateChange(readonlyStateActive: boolean) {
		this.permisosEditable = !readonlyStateActive;
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public identificadorsService: IdentificadorsService,
		public identificadorsPermissionService: IdentificadorsPermissionService) {
		super(activatedRoute);
		this.setConfigExternalFormComponents([
			{ resourceName: 'usuari', component: BngUsuarisForm }
		]);
		activatedRoute.params.subscribe((params) => {
			identificadorsPermissionService.setPermissionResourceId(params.id);
		});
	}

}