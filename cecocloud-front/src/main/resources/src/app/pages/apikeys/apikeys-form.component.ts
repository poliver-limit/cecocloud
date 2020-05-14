import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { ApikeysService } from './apikeys.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="apikeysService">
</bng-form>
`
})
export class ApikeysFormComponent extends BngFormBaseComponent {

	constructor(
		activatedRoute: ActivatedRoute,
		public apikeysService: ApikeysService) {
		super(activatedRoute);
		this.formConfig.readOnlyStateEnabled = false;
	}

}