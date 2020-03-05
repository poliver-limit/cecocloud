import { Component } from '@angular/core';
import { BngAuthService, BngRestapiProfile, BngRestapiResource, BngDatagridConfig } from 'base-angular';

import { IdentificadorsService, Funcionalitat } from './identificadors.service';
import { IdentificadorsPermissionService } from './identificadors-permission.service';

@Component({
	template: `
<bng-header>
	<span>{{'resource.identificador' | translate}}</span>
	<span class="toolbar-fill"></span>
</bng-header>
<div *ngIf="identificador" class="mat-elevation-z4 page-like">
	<h2 class="mat-display-1" style="margin-bottom:16px">
		{{identificador.codi}}<br/>
		<span class="mat-h1">{{identificador.descripcio}}&nbsp;</span>
		<span class="mat-h4" style="color: rgba(0, 0, 0, 0.54)">(llicència vàlida fins el {{identificador.dataFi | date:'dd/MM/yyyy'}})</span>
	</h2>
	<div *ngIf="restapiResource" style="display: flex">
		<bng-form-field-readonly
			fieldName="propietari"
			[resourceInstance]="identificador"
			[restapiResource]="restapiResource"
			style="width: 50%; padding-right: 2em"></bng-form-field-readonly>
		<div style="width: 50%; display: flex">
			<bng-form-field-readonly
				fieldName="numUsuaris"
				[resourceInstance]="identificador"
				[restapiResource]="restapiResource"
				style="width: 33.3%; padding-right: 1em"></bng-form-field-readonly>
			<bng-form-field-readonly
				fieldName="numEmpreses"
				[resourceInstance]="identificador"
				[restapiResource]="restapiResource"
				style="width: 33.3%; padding-right: 1em"></bng-form-field-readonly>
			<bng-form-field-readonly
				fieldName="numOperaris"
				[resourceInstance]="identificador"
				[restapiResource]="restapiResource"
				style="width: 33.3%"></bng-form-field-readonly>
		</div>
	</div>
	<div *ngIf="restapiResource" style="display: flex">
		<bng-form-field-readonly
			fieldName="dataInici"
			[resourceInstance]="identificador"
			[restapiResource]="restapiResource"
			style="width: 50%; padding-right: 2em"></bng-form-field-readonly>
		<bng-form-field-readonly
			fieldName="dataFi"
			[resourceInstance]="identificador"
			[restapiResource]="restapiResource"
			style="width: 50%"></bng-form-field-readonly>
	</div>
	<h2 class="mat-display-1" style="display:flex;justify-content:space-around;margin:1em 0">
		<div>
			<mat-icon>apartment</mat-icon> {{identificador.empresesCount}} / {{identificador.numEmpreses}}
		</div>
		<div>
			<mat-icon>people</mat-icon> {{identificador.usuarisCount}} / {{identificador.numUsuaris}}
		</div>
		<div>
			<mat-icon>perm_contact_calendar</mat-icon> {{identificador.operarisCount}} / {{identificador.numOperaris}}
		</div>
	</h2>
	<mat-tab-group animationDuration="0">
		<mat-tab label="{{'resource.permission.plural' | translate}}">
			<br/>
			<bng-datagrid
				[config]="permisosDatagridConfig"
				[restapiService]="identificadorsPermissionService"
				[editable]="true"></bng-datagrid>
		</mat-tab>
		<mat-tab label="{{'resource.funcionalitat.plural' | translate}}">
			<mat-accordion>
				<mat-expansion-panel *ngFor="let modulCodi of modulsCodis">
					<mat-expansion-panel-header>
						<mat-panel-title class="mat-h2" style="margin:0">{{'app.module.' + modulCodi | translate}}</mat-panel-title>
						<!--mat-panel-description>Type your description</mat-panel-description-->
					</mat-expansion-panel-header>
					<mat-list>
						<mat-list-item *ngFor="let funcionalitat of funcionalitats[modulCodi]">{{funcionalitat.codi}} {{funcionalitat.descripcio}}</mat-list-item>
					</mat-list>
				</mat-expansion-panel>
			</mat-accordion>
		</mat-tab>
	</mat-tab-group>
</div>`,
	styles: [`
.page-like {
	margin: 1em;
	padding: 2em;
	background-color: white;
}
`]
})
export class IdentificadorComponent {

	id: any;
	restapiResource: BngRestapiResource;
	identificador: any;
	funcionalitats: any = {};
	modulsCodis: string[];

	permisosDatagridConfig: BngDatagridConfig = {
		mode: 'form',
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

	configurarAmbIdentificador(id: any) {
		this.id = id;
		this.identificadorsPermissionService.setPermissionResourceId(this.id);
		this.identificadorsService.whenReady().subscribe((restapiProfile: BngRestapiProfile) => {
			this.restapiResource = restapiProfile.resource;
			this.identificadorsService.get(this.id).subscribe((identificador: any) => {
				this.identificador = identificador;
				identificador.getRelationArray(Funcionalitat, 'funcionalitats').subscribe((funcionalitats: any[]) => {
					// Obté els diferents mòduls de les funcionalitats d'aquest identificador
					let modulsCodis: string[] = funcionalitats.filter((value, index, array) => {
						return array.findIndex((element) => {
							return element.modul == value.modul;
						}) === index;
					}).map((value) => {
						return value.modul;
					});
					this.modulsCodis = modulsCodis;
					modulsCodis.forEach((modulCodi: string) => {
						this.funcionalitats[modulCodi] = funcionalitats.filter((element: any) => {
							return element.modul === modulCodi;
						});
					});
				});
			});
		});
	}

	constructor(
		authService: BngAuthService,
		public identificadorsService: IdentificadorsService,
		public identificadorsPermissionService: IdentificadorsPermissionService) {
		if (authService.getSession()) {
			this.configurarAmbIdentificador(authService.getSession().i);
		}
		authService.getAuthTokenChangeEvent().subscribe(() => {
			if (authService.getSession()?.i)
				this.configurarAmbIdentificador(authService.getSession().i);
		});
	}

}