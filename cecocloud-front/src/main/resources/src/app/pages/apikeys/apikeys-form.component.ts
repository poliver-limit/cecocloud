import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { ApikeysService } from './apikeys.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="apikeysService"
	(resourceSave)="onFormResourceSave($event)">
	<mat-card *ngIf="showKey" class="background-accent">
		<mat-card-content>
			<p>Assegura't de fer una còpia d'aquesta clau. Quan tanquis aquest formulari no podràs consultar-la de nou.</p>
			<pre>{{key}}</pre>
		</mat-card-content>
	</mat-card>
</bng-form>
`
})
export class ApikeysFormComponent extends BngFormBaseComponent {

	showKey: boolean;
	key: boolean;

	onFormResourceSave(apiKey: any) {
		console.log('>>> apiKey', apiKey.resource.key)
		if (apiKey.resource.key) {
			this.key = apiKey.resource.key;
			this.showKey = true;
		} else {
			this.showKey = false;
		}
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public apikeysService: ApikeysService) {
		super(activatedRoute);
		this.formConfig.readOnlyStateEnabled = false;
	}

}