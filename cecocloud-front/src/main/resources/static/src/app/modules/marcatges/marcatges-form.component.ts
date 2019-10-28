import { Component } from '@angular/core';
import { BngFormConfig } from '@programari-limit/bang';

import { MarcatgesService } from './marcatges.service';

@Component({
	template: `
	<bng-form
		restapi-form-mant
		[config]="formConfig"
		[restapiService]="marcatgesService"
		(resourceChange)="onResourceChange($event)"></bng-form>
	<map *ngIf="showMap"
		[longitude]="longitud"
		[latitude]="latitud"></map>
`
})
export class MarcatgesFormComponent {

	longitud: number;
	latitud: number;
	showMap: boolean = false;

	formConfig: BngFormConfig = {
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