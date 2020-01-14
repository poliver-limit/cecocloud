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
	[restapiService]="identificadorsService"
	(resourceChange)="onResourceLoaded($event)">
	<!--ng-container *ngIf="identificador">
		<h2 class="mat-display-1" style="margin-bottom:16px">
			{{identificador.codi}}<br/>
			<span class="mat-h1">{{identificador.descripcio}}&nbsp;</span>
			<span class="mat-h4" style="color: rgba(0, 0, 0, 0.54)">(llicència vàlida fins el {{identificador.dataFi | date:'dd/MM/yyyy'}})</span>
		</h2>
	</ng-container>
	<mat-tab-group animationDuration="0">
		<mat-tab>
			<ng-template matTabLabel>
				<span [matBadge]="identificador?.usuarisCount" matBadgeOverlap="false" matBadgeSize="small">Usuaris</span>
			</ng-template>
			<p class="mat-elevation-z4" style="margin: 1em; padding: 1em">
				<mat-icon style="position: relative; margin-top: -6px; top: 6px;">info</mat-icon>
				La seva llicència permet crear fins a un màxim de {{identificador?.numUsuaris}} usuaris.
			</p>
		</mat-tab>
		<mat-tab>
			<ng-template matTabLabel>
				<span [matBadge]="identificador?.empresesCount" matBadgeOverlap="false" matBadgeSize="small">Empreses</span>
			</ng-template>
			<p class="mat-elevation-z4" style="margin: 1em; padding: 1em">
				<mat-icon style="position: relative; margin-top: -6px; top: 6px;">info</mat-icon>
				La seva llicència permet crear fins a un màxim de {{identificador?.numEmpreses}} empreses.
			</p>
		</mat-tab>
	</mat-tab-group-->
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

	identificador: any;

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

	onResourceLoaded(resource: any) {
		this.identificador = resource;
	}

	constructor(
		private authService: BngAuthService,
		activatedRoute: ActivatedRoute,
		public identificadorsService: IdentificadorsService,
		public identificadorsPermissionService: IdentificadorsPermissionService) {
		this.id = authService.getSession().i;
		identificadorsPermissionService.setPermissionResourceId(this.id);
	}

}