import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngAuthService, BngFormConfig } from 'base-angular';

import { CompanyiesService } from './companyies.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[id]="id"
	[config]="formConfig"
	[restapiService]="companyiesService">
</bng-form>
`
})
export class CompanyiaComponent {

	id: any;

	formConfig: BngFormConfig = {
		
	}

	constructor(
		private authService: BngAuthService,
		activatedRoute: ActivatedRoute,
		public companyiesService: CompanyiesService) {
		this.id = authService.getSession().companyia;
	}

}