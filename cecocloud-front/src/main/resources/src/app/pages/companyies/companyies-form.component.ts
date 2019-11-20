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
	<ng-container *ngIf="id">
		<bng-datagrid
			[config]="permisosDatagridConfig"
			[restapiService]="companyiesPermissionService"></bng-datagrid>
	</ng-container>
</bng-form>
`
})
export class CompanyiesFormComponent {

	id: any;
	formConfig: BngFormConfig = {
		readOnlyStateEnabled: true
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