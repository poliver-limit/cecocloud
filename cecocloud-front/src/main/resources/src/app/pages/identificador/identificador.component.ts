import { Component } from '@angular/core';
import { BngAuthService, BngRestapiProfile, BngRestapiResource } from 'base-angular';

import { IdentificadorsService } from '../identificadors/identificadors.service';

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
	<h2 class="mat-display-1" style="display:flex;justify-content:space-between;margin:1em 0">
		<div style="padding-right: 1em">
			<mat-icon>apartment</mat-icon> {{identificador.empresesCount}} / {{identificador.numEmpreses}}
		</div>
		<div style="padding-right: 1em">
			<mat-icon>people</mat-icon> {{identificador.usuarisCount}} / {{identificador.numUsuaris}}
		</div>
		<div>
			<mat-icon>perm_contact_calendar</mat-icon> {{identificador.operarisCount}} / {{identificador.numOperaris}}
		</div>
	</h2>
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
	identificador: any;
	restapiResource: BngRestapiResource;

	constructor(
		authService: BngAuthService,
		public identificadorsService: IdentificadorsService) {
		this.id = authService.getSession().i;
		this.identificadorsService.whenReady().subscribe((restapiProfile: BngRestapiProfile) => {
			this.restapiResource = restapiProfile.resource;
			this.identificadorsService.get(this.id).subscribe((identificador: any) => {
				this.identificador = identificador;
			});
		});
	}

}