import { Component, AfterViewInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngAuthService, BngFormConfig, BngFormFieldConfig, BngForm } from 'base-angular';

import { ConfiguracionsService } from '../configuracions/configuracions.service';

@Component({
	template: `
<bng-form
	bng-form-mant	
	[config]="formConfig"
	[restapiService]="configuracionsService"
	>
	
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
		public configuracionsService: ConfiguracionsService,
        )
         {
		this.configuracio = authService.getSession().i;
	}

}