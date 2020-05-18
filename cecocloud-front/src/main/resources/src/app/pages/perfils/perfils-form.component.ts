import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { PerfilsService } from './perfils.service';

@Component({
	template: `
<bng-form
    bng-form-mant
    [config]="formConfig"
    [restapiService]="perfilsService">
	<div style="display: flex">
		<bng-custom-field name="codi" style="width: 30%"></bng-custom-field>
	</div>
	<!--button mat-raised-button (click)="onRefreshClick()">Refresh</button-->
	<bng-custom-field name="descripcio"></bng-custom-field>
	<ng-container *ngIf="id">
		<cec-funcionalitats [perfil]="id"></cec-funcionalitats>
	</ng-container>
</bng-form>`
})
export class PerfilsFormComponent extends BngFormBaseComponent {

	onRefreshClick() {
		console.log('>>> onRefreshClick', this.id)
		this.perfilsService.refresh(this.id).subscribe(() =>  {
			console.log('>>> refresh ok', this.id)
		});
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public perfilsService: PerfilsService) {
		super(activatedRoute);
		this.formConfig.readOnlyStateEnabled = false;
	}

}