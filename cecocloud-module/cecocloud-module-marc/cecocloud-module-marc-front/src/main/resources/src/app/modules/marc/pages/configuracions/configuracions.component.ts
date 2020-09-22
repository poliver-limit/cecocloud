import { Component } from '@angular/core';
import { HalParam } from '@lagoshny/ngx-hal-client';
import { BngAuthService, BngFormConfig } from 'base-angular';

import { ConfiguracionsService } from '../configuracions/configuracions.service';

@Component({
	template: `
<bng-form
	*ngIf="mostrar"
	bng-form-mant
	[id]="id"
	[config]="formConfig"
	[restapiService]="configuracionsService"
	(resourceSave)="refresh()">
	<div style="display:flex">
		<bng-custom-field name="intervalValidacio" style="width:50%;padding-right:2em"></bng-custom-field>
	</div>
	<div style="display:flex">
		<bng-custom-field name="maxDistanciaInterval" style="width:50%;padding-right:2em"></bng-custom-field>
	</div>
	<bng-custom-field name="offlinePermes" style="width:calc(100%)"></bng-custom-field>
	<bng-custom-field name="validacioOfflineAutomatica" style="width:calc(100%)"></bng-custom-field>
	<bng-custom-field name="mostrarTempsAcumulat" style="width:calc(100%)"></bng-custom-field>
</bng-form>
`
})
export class ConfiguracionsComponent {

	id: any;
	mostrar: boolean = false;
	formConfig: BngFormConfig = {
		mode: 'isolated'
	}

	refresh() {
		this.mostrar = false;
		this.configuracionsService.whenReady().subscribe(() => {
			const cRequestParams: HalParam[] = [];
			cRequestParams.push({ key: 'query', value: 'empresa.id==' + this.authService.getSession().e });
			this.configuracionsService.getAll({ params: cRequestParams }).subscribe((configuracio: any[]) => {
				if (configuracio && configuracio.length) {
					console.log("Id:", configuracio[0].id);
					this.id = configuracio[0].id;
				}
				this.mostrar = true;
			})
		});
	}

	constructor(
		private authService: BngAuthService,
		public configuracionsService: ConfiguracionsService) {
		this.refresh();
	}

}