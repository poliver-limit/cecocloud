import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngDatagridConfig } from 'base-angular';

import { LlocFeinaService } from './llocFeina.service';
import { OperariEmpresaLlocFeinaService } from './operariEmpresaLlocFeina.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="llocFeinaService"
	(resourceLoad)="onResourceLoad($event)">
	<bng-custom-field name="nom"></bng-custom-field>
	<bng-custom-field name="adressa"></bng-custom-field>
	<div style="display:flex">
		<div [ngStyle]="{'width': (showMap ? '50%' : '100%')}" style="padding-right:2em">
			<bng-custom-field name="adrecesIpPermeses"></bng-custom-field>
			<bng-custom-field name="latitud"></bng-custom-field>
			<bng-custom-field name="longitud"></bng-custom-field>
			<bng-custom-field name="distanciaMaxima"></bng-custom-field>
		</div>
		<div *ngIf="showMap" style="width:50%">
			<map
				[longitude]="longitud"
				[latitude]="latitud"
				[precision]="distanciaMaxima"></map>
		</div>
	</div>
	<ng-container *ngIf="id">
		<mat-tab-group>
			<mat-tab label="{{'resource.operariEmpresaLlocFeina.plural' | translate}}">
				<br/>
				<bng-datagrid
					*ngIf="showGrid"
					[config]="operariEmpresaLlocFeinaDatagridConfig"
					[restapiService]="operariEmpresaLlocFeinaService"
					[editable]="true"></bng-datagrid>
			</mat-tab>
		</mat-tab-group>
	</ng-container>
</bng-form>
`
})
export class LlocFeinaFormComponent extends BngFormBaseComponent {

	latitud: number;
	longitud: number;
	distanciaMaxima: number;
	showMap: boolean;
	showGrid: boolean;

	operariEmpresaLlocFeinaDatagridConfig: BngDatagridConfig = {
		mode: 'form',
		columns: [{
			field: 'operariEmpresa',
			width: 100
		}]
	};

	onResourceLoad(llocFeina: any) {
		if (llocFeina.latitud && llocFeina.longitud) {
			this.latitud = llocFeina.latitud;
			this.longitud = llocFeina.longitud;
			this.distanciaMaxima = llocFeina.distanciaMaxima;
			this.showMap = true;
		}
		this.operariEmpresaLlocFeinaDatagridConfig.fixedFilter = 'llocFeina.id==' + llocFeina.id;
		this.showGrid = true;
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public llocFeinaService: LlocFeinaService,
		public operariEmpresaLlocFeinaService: OperariEmpresaLlocFeinaService) {
		super(activatedRoute);
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.operariEmpresaLlocFeinaDatagridConfig.fixedRowData = {
					llocFeina: {
						id: params.id,
						description: undefined
					}
				}
			}
		});
		this.formConfig.readOnlyStateEnabled = false;
	}

}