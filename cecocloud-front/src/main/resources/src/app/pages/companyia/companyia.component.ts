import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngAuthService, BngFormConfig } from 'base-angular';

import { CompanyiesService } from './companyies.service';
import { CompanyiesPermissionService } from './companyies-permission.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[id]="id"
	[config]="formConfig"
	[restapiService]="companyiesService">
	<div style="display: flex">
		<bng-custom-field name="codi" style="width: 30%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="nom" style="width: 70%"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="telefon" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="email" style="width: 50%"></bng-custom-field>
	</div>
	<mat-tab-group>
		<mat-tab label="Permisos">
			<br/>
			<bng-datagrid
				[config]="permisosDatagridConfig"
				[restapiService]="companyiesPermissionService"
				editable="true"></bng-datagrid>
		</mat-tab>
	</mat-tab-group>
</bng-form>
`
})
export class CompanyiaComponent {

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
		public companyiesService: CompanyiesService,
		public companyiesPermissionService: CompanyiesPermissionService) {
		this.id = authService.getSession().c;
		companyiesPermissionService.setPermissionResourceId(this.id);
	}

}