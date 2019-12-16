import { IdentificadorsPermissionService } from './identificadors-permission.service';
import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { IdentificadorsService } from './identificadors.service';
import { ActivatedRoute } from '@angular/router';

@Component({
	template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
		[restapiService]="identificadorsService">
		<!-- (actionSave)="onIdentificadorSave($event)" -->
        <ng-container *ngIf="id">
		<mat-tab-group>
			<mat-tab label="Permisos">
				<br/>
				<bng-datagrid
					[config]="permisosDatagridConfig"
					[restapiService]="identificadorsPermissionService"
					editable="true"></bng-datagrid>
			</mat-tab>
			<mat-tab label="Altres">
			</mat-tab>
		</mat-tab-group>
	</ng-container>
    </bng-form>
`
})
export class IdentificadorsFormComponent {

	id: any;
	formConfig: BngFormConfig = {
		readOnlyStateEnabled: true
	}

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

	// onIdentificadorSave(event) {
	// 	// TODO: Refrescar selector empreses
	// }

	constructor(
		activatedRoute: ActivatedRoute,
		public identificadorsService: IdentificadorsService,
		public identificadorsPermissionService: IdentificadorsPermissionService) {
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.id = params.id;
			}
			identificadorsPermissionService.setPermissionResourceId(params.id);
		});
	}

}