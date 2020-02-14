import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent, BngRestapiProfile } from 'base-angular';

import { MarcatgesService } from './marcatges.service';
import { OperarisEmpresesService } from './operaris-empreses.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="marcatgesService"
	(resourceLoad)="onResourceLoad($event)">
	<div style="display: flex">
		<bng-custom-field name="operariEmpresa" style="width: 30%; padding-right: 2em"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="data" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="origen" style="width: 50%"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="latitud" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="longitud" style="width: 50%"></bng-custom-field>
	</div>
	<map *ngIf="showMap"
		[longitude]="longitud"
		[latitude]="latitud"></map>
</bng-form>
`
})
export class MarcatgesFormComponent extends BngFormBaseComponent {

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
		public marcatgesService: MarcatgesService,
		operarisEmpresesService: OperarisEmpresesService) {
		super(activatedRoute);
		marcatgesService.whenReady().subscribe((marcatgesProfile: BngRestapiProfile) => {
			this.isAdmin = marcatgesProfile.resource.hasAdminPermission;
			if (!this.isAdmin) {
				operarisEmpresesService.getHttpClient().get(operarisEmpresesService.getApiBaseUrl() + '/current').subscribe((operariEmpresa: any) => {
					console.log('>>> Current no admin', operariEmpresa);
				});
			} else {
				operarisEmpresesService.getHttpClient().get(operarisEmpresesService.getApiBaseUrl() + '/current').subscribe((operariEmpresa: any) => {
					console.log('>>> Current admin', operariEmpresa);
				});
			}
		});
	}

}