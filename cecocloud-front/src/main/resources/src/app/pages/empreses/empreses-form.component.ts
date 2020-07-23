import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngDatagridConfig } from 'base-angular';

import { EmpresesService } from './empreses.service';
import { UsuarisIdentificadorsEmpresesService } from './usuaris-identificadors-empreses.service';
import { OperarisEmpresesService } from './operaris-empreses.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="empresesService">
	<div style="display: flex">
		<bng-custom-field name="codi" style="width: 30%; padding-right: 2em"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="nif" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="nom" style="width: 50%"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="tipus" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="empresaComptable" style="width: 50%"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="activa" style="width: 50%"></bng-custom-field>
	</div>
	<ng-container *ngIf="id">
		<mat-tab-group animationDuration="0">
			<mat-tab label="{{'resource.usuariIdentificador.plural' | translate}}">
				<br/>
				<bng-datagrid
					[config]="usuarisIdentificadorsEmpresesDatagridConfig"
					[restapiService]="usuarisIdentificadorsEmpresesService"
					[editable]="true"></bng-datagrid>
			</mat-tab>
			<mat-tab label="{{'resource.operari.plural' | translate}}">
				<br/>
				<bng-datagrid
					[config]="operarisDatagridConfig"
					[restapiService]="operarisEmpresesService"
					[editable]="true"></bng-datagrid>
			</mat-tab>
		</mat-tab-group>
	</ng-container>
</bng-form>
`
})
export class EmpresesFormComponent extends BngFormBaseComponent {

	usuarisIdentificadorsEmpresesDatagridConfig: BngDatagridConfig = {
		mode: 'form',
		paginationEnabled: false,
		columns: [{
			field: 'usuariIdentificador',
			width: 80
		}]
	};
	operarisDatagridConfig: BngDatagridConfig = {
		mode: 'form',
		paginationEnabled: false,
		columns: [{
			field: 'operari',
			width: 80
		}]
	};

	constructor(
		activatedRoute: ActivatedRoute,
		public empresesService: EmpresesService,
		public usuarisIdentificadorsEmpresesService: UsuarisIdentificadorsEmpresesService,
		public operarisEmpresesService: OperarisEmpresesService) {
		super(activatedRoute);
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.usuarisIdentificadorsEmpresesDatagridConfig.fixedFilter = 'empresa.id==' + params.id;
				this.usuarisIdentificadorsEmpresesDatagridConfig.fixedRowData = {
					empresa: {
						id: params.id,
						description: undefined
					}
				}
				this.operarisDatagridConfig.fixedFilter = 'empresa.id==' + params.id;
				this.operarisDatagridConfig.fixedRowData = {
					empresa: {
						id: params.id,
						description: undefined
					}
				}
			}
		});
		this.formConfig.readOnlyStateEnabled = false;
	}

}