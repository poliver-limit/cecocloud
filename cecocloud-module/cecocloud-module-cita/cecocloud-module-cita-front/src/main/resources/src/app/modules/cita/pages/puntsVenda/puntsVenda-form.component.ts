import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { PuntsVendaService } from './puntsVenda.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="puntsVendaService"
	(resourceLoad)="onResourceLoad($event)">
</bng-form>
`
})
export class PuntsVendaFormComponent extends BngFormBaseComponent {

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
		public puntsVendaService: PuntsVendaService) {
		super(activatedRoute);
		this.formConfig.readOnlyStateEnabled = false;
	}

}