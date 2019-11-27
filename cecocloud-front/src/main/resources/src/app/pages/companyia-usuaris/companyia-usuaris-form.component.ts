import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { UsuarisService } from './usuaris.service';

@Component( {
    template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="usuarisService"
	(resourceChange)="onResourceChange($event)">
	<div style="display: flex">
		<div style="width: 80%; display: flex">
			<bng-custom-field name="nom" style="width: 50%; padding-right: 2em" disabled="disabled"></bng-custom-field>
			<bng-custom-field name="llinatges" style="width: 50%"disabled="disabled"></bng-custom-field>
		</div>
	</div>
	<div style="display: flex">
		<div style="width: 80%; display: flex">
			<bng-custom-field name="email" style="width: 50%; padding-right: 2em"></bng-custom-field>
			<bng-custom-field name="imatgeUrl" style="width: 50%"></bng-custom-field>
		</div>
		<bng-custom-field name="actiu" style="margin-left: 2em"></bng-custom-field>
	</div>
	<div style="display: flex">
		<div style="width: 80%">
			<bng-custom-field name="rols"></bng-custom-field>
		</div>
		<div style="width: 20%">
		</div>
	</div>
</bng-form>
`
} )
export class CompanyiaUsuarisFormComponent {

    formConfig: BngFormConfig = {
	};
	usuariId: number;

	onResourceChange(usuari: any) {
		this.usuariId = usuari.id;
	}

    constructor(
        public usuarisService: UsuarisService ) { }

}