import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig } from 'base-angular';

import { CompanyiesService } from './companyies.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="companyiesService"></bng-form>
`
})
export class CompanyiaComponent {

	id: any;

	formConfig: BngFormConfig = {
	}

	constructor(
		activatedRoute: ActivatedRoute,
		public companyiesService: CompanyiesService) {
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.id = params.id;
			}
		});
	}

}