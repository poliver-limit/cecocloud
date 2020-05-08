import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { FestiusGrupService } from './festiusGrup.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="festiusGrupService"
	(resourceLoad)="onResourceLoad($event)">
</bng-form>
`
})
export class FestiusGrupFormComponent extends BngFormBaseComponent {

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
		public festiusGrupService: FestiusGrupService) {
		super(activatedRoute);
		this.formConfig.readOnlyStateEnabled = false;
	}

}