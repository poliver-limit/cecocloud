import { Component } from '@angular/core';

import { FormConfig } from '../../shared/restapi-form/restapi-form.component';
import { UsuarisService } from './usuaris.service';

@Component( {
    template: `
<restapi-form
	restapi-form-mant
	[config]="formConfig"
	[restapiService]="usuarisService"
	(resourceChange)="onResourceChange($event)">
	<div style="display: flex">
		<div style="width: 80%; display: flex">
			<restapi-custom name="codi" style="width: 50%; padding-right: 2em"></restapi-custom>
			<restapi-custom name="nom" style="width: 50%"></restapi-custom>
		</div>
		<restapi-custom name="validat" style="margin-left: 2em"></restapi-custom>
	</div>
	<div style="display: flex">
		<div style="width: 80%; display: flex">
			<restapi-custom name="email" style="width: 50%; padding-right: 2em"></restapi-custom>
			<restapi-custom name="imatgeUrl" style="width: 50%"></restapi-custom>
		</div>
		<restapi-custom name="actiu" style="margin-left: 2em"></restapi-custom>
	</div>
	<div style="display: flex">
		<div style="width: 80%">
			<restapi-custom name="rols"></restapi-custom>
		</div>
		<div style="width: 20%">
		</div>
	</div>
	<restapi-custom *ngIf="usuariId" name="contrasenya"><usuari-contrasenya #customField [usuariId]="usuariId"></usuari-contrasenya></restapi-custom>
</restapi-form>
`
} )
export class UsuarisFormComponent {

    formConfig: FormConfig = {};
	usuariId: number;

	onResourceChange(usuari: any) {
		this.usuariId = usuari.id;
	}

    constructor(
        public usuarisService: UsuarisService ) { }

}