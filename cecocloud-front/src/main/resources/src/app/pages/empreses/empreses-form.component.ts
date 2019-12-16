import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig } from 'base-angular';

import { EmpresesService } from './empreses.service';
import { EmpresesPermissionService } from './empreses-permission.service';

@Component({
	template: `
	<bng-form
		bng-form-mant
		[config]="formConfig"
		[restapiService]="empresesService"
		(readonlyStateChange)="onReadonlyStateChange($event)">
		<ng-container *ngIf="id">
			<mat-tab-group>
				<mat-tab label="Permisos">
					<br/>
					<bng-datagrid
						[config]="permisosDatagridConfig"
						[restapiService]="empresesPermissionService"
						[editable]="permisosEditable">
					</bng-datagrid>
				</mat-tab>
			</mat-tab-group>
		</ng-container>
	</bng-form>
`
})
export class EmpresesFormComponent {

	id: any;
	permisosEditable: boolean;

	formConfig: BngFormConfig = {
		readOnlyStateEnabled: true
	}

	permisosDatagridConfig = {
		//columnFiltersEnabled: true
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
			field: 'readGranted',
			width: 10
		}]
	};

	onReadonlyStateChange(readonlyStateActive: boolean) {
		this.permisosEditable = !readonlyStateActive;
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public empresesService: EmpresesService,
		public empresesPermissionService: EmpresesPermissionService) {
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.id = params.id;
			}
		});
		if (this.id) {
			empresesPermissionService.setPermissionResourceId(this.id);
		}
	}

}