import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig } from 'base-angular';

import { CompanyiesService } from './companyies.service';
import { CompanyiesPermissionService } from './companyies-permission.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="companyiesService">
	<ng-container *ngTemplateOutlet="fieldsTemplate"></ng-container>
	<ng-container *ngIf="id">
		<mat-tab-group>
			<mat-tab label="Permisos">
				<br/>
				<bng-datagrid
					[config]="permisosDatagridConfig"
					[restapiService]="companyiesPermissionService"
					editable="true"></bng-datagrid>
			</mat-tab>
		</mat-tab-group>
	</ng-container>
	<ng-template #fieldsTemplate>
		<div style="display: flex">
			<bng-custom-field name="codi" style="width: 30%; padding-right: 2em"></bng-custom-field>
			<bng-custom-field name="nom" style="width: 70%"></bng-custom-field>
		</div>
		<div style="display: flex">
			<bng-custom-field name="telefon" style="width: 50%; padding-right: 2em"></bng-custom-field>
			<bng-custom-field name="email" style="width: 50%"></bng-custom-field>
		</div>
	</ng-template>
</bng-form>
`
})
export class CompanyiesFormComponent {

	id: any;
	formConfig: BngFormConfig = {
	};
	permisosDatagridConfig = {
		//columnFiltersEnabled: true
		adjustHeight: false,
		paginationEnabled: false,
		mode: 'form',
		editable: true,
		columns: [{
			field: 'sidType',
			width: 30
		}, {
			field: 'sidName',
			width: 40
		}, {
			field: 'readGranted',
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
		activatedRoute: ActivatedRoute,
		public companyiesService: CompanyiesService,
		public companyiesPermissionService: CompanyiesPermissionService) {
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.id = params.id;
			}
			companyiesPermissionService.setPermissionResourceId(params.id);
		});
	}

}