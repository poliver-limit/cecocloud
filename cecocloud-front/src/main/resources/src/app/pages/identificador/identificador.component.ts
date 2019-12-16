import { Component, AfterViewInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngAuthService, BngFormConfig, BngFormFieldConfig, BngForm } from 'base-angular';

import { IdentificadorsService } from '../identificadors/identificadors.service';
import { IdentificadorsPermissionService } from '../identificadors/identificadors-permission.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[id]="id"
	[config]="formConfig"
	[restapiService]="identificadorsService">
	<div style="display: flex">
		<bng-custom-field name="codi" style="width: 30%; padding-right: 2em"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="descripcio" style="width: 100%"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="numUsuaris" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="numEmpreses" style="width: 50%"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="dataInici" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="dataFi" style="width: 50%"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="propietari" style="width: 100%"></bng-custom-field>
	</div>
	<mat-tab-group>
		<mat-tab label="Permisos">
			<br/>
			<bng-datagrid
				[config]="permisosDatagridConfig"
				[restapiService]="identificadorsPermissionService"
				editable="true"></bng-datagrid>
		</mat-tab>
	</mat-tab-group>
</bng-form>
`
})
export class IdentificadorComponent {

	// TODO: Fer que els camps siguin disabled
	id: any;

	formConfig: BngFormConfig = {
		mode: 'isolated'
	}
	permisosDatagridConfig = {
		adjustHeight: false,
		paginationEnabled: false,
		mode: 'form',
		columns: [{
			field: 'sidType',
			width: 30
		}, {
			field: 'sidName',
			width: 40
		}, {
			field: 'accessGranted',
			width: 10
		}, {
			field: 'adminGranted',
			width: 10
		}, {
			field: 'syncGranted',
			width: 10
		}]
	};

	constructor(
		private authService: BngAuthService,
		activatedRoute: ActivatedRoute,
		public identificadorsService: IdentificadorsService,
		public identificadorsPermissionService: IdentificadorsPermissionService) {
		this.id = authService.getSession().i;
		identificadorsPermissionService.setPermissionResourceId(this.id);
	}

}