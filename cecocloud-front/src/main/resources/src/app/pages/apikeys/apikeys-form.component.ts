import { Component, OnInit } from '@angular/core';
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
	<mat-card *ngIf="key" class="background-accent">
		<mat-card-content>
			<p>{{'page.api-key.form.key.show.msg' | translate}}</p>
			<pre>{{key}}</pre>
		</mat-card-content>
	</mat-card>
</bng-form>
`
})
export class ApikeysFormComponent extends BngFormBaseComponent implements OnInit {

	key: string;

	ngOnInit() {
		this.key = this.apikeysService.retrieve();
	}

	onFormResourceSave(apiKey: any) {
		this.apikeysService.store(apiKey.resource.key);
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public apikeysService: ApikeysService) {
		super(activatedRoute);
		this.formConfig.readOnlyStateEnabled = false;
	}

}