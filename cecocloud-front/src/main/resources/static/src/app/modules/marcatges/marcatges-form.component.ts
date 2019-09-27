import { Component } from '@angular/core';

import { FormConfig } from '../../shared/restapi-form/restapi-form.component';
import { MarcatgesService } from './marcatges.service';

@Component({
	template: `
	<restapi-form
		restapi-form-mant
		[config]="formConfig"
		[restapiService]="marcatgesService"
		(resourceChange)="onResourceChange($event)"></restapi-form>
	<map *ngIf="showMap"
		[longitude]="longitud"
		[latitude]="latitud"></map>
`
})
export class MarcatgesFormComponent {

	longitud: number;
	latitud: number;
	showMap: boolean = false;

	formConfig: FormConfig = {
	}

	onResourceChange(resource: any) {
		if (resource.ubicacio) {
			this.longitud = resource.longitud;
			this.latitud = resource.latitud;
			this.showMap = true;
		}
	}

	constructor(
		public marcatgesService: MarcatgesService) { }

}