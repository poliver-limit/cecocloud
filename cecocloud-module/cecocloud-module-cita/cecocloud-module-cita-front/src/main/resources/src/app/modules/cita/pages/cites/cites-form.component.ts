import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { CitesService } from './cites.service';
//import { OperarisEmpresesService } from './operaris-empreses.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="citesService"
	(resourceLoad)="onResourceLoad($event)">
</bng-form>
`
})
export class CitesFormComponent extends BngFormBaseComponent {

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
		public citesService: CitesService) {
		super(activatedRoute);
		this.formConfig.readOnlyStateEnabled = false;
	}

}