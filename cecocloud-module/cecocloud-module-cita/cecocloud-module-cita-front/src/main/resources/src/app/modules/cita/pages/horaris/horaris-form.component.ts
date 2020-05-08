import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { HorarisService } from './horaris.service';
//import { OperarisEmpresesService } from './operaris-empreses.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="horarisService"
	(resourceLoad)="onResourceLoad($event)">
</bng-form>
`
})
export class HorarisFormComponent extends BngFormBaseComponent {

	isAdmin: boolean;
	longitud: number;
	latitud: number;
	showMap: boolean;

	onResourceLoad(resource: any) {
		if (resource.ubicacio) {
			this.longitud = resource.longitud;
			this.latitud = resource.latitud;
			this.showMap = true;
		}
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public horarisService: HorarisService) {
		super(activatedRoute);
		this.formConfig.readOnlyStateEnabled = false;
	}

}