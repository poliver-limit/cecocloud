import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { CitesService } from './cites.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="citesService"
	(resourceLoad)="onResourceLoad($event)">
	<div style="display: flex">
		<bng-custom-field name="data" style="width: 50%"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="nom" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="llinatges" style="width: 50%"></bng-custom-field>
	</div>
	<div style="display: flex">
		<bng-custom-field name="telefon" style="width: 50%; padding-right: 2em"></bng-custom-field>
		<bng-custom-field name="email" style="width: 50%"></bng-custom-field>
	</div>
	<bng-custom-field name="puntVenda"></bng-custom-field>
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