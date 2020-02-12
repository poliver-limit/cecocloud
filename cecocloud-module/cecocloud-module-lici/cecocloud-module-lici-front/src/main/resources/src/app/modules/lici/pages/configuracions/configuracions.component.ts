import { Component, AfterViewInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HalParam } from 'angular4-hal';
import { BngAuthService, BngFormConfig, BngFormFieldConfig, BngForm } from 'base-angular';

import { ConfiguracionsService } from '../configuracions/configuracions.service';

@Component({
	template: `
<bng-form
	*ngIf="id"
	bng-form-mant	
	[config]="formConfig"
	[restapiService]="configuracionsService"
	[id]="id"
	(resourceChange)="onResourceLoaded($event)">
	
	<div style="display: flex">
		<bng-custom-field name="sincronitzacioActiva" style="width: 50%; padding-right: 2em"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="filtreProvincia" style="width: 100%"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="filtreCpv" style="width: 100%"></bng-custom-field>		
	</div>	
	
</bng-form>
`
})
export class ConfiguracionsComponent {

	// TODO: Fer que els camps siguin disabled
	id: any;

	 configuracio: any;

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
		this.configuracio = resource;
	}

	constructor(
		private authService: BngAuthService,
		activatedRoute: ActivatedRoute,
		public configuracionsService: ConfiguracionsService){
			this.configuracionsService.whenReady().subscribe(() => {
				const cRequestParams: HalParam[] = [];
				cRequestParams.push({ key: 'query', value: 'empresa.id==' + this.authService.getSession().e });
				this.configuracionsService.getAll({ params: cRequestParams }).subscribe((configuracio: any) => {
					console.log("Id:", configuracio[0].id);
					this.id = configuracio[0].id;
				})
			})
	}

}