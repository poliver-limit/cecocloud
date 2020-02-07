import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { RecursosService } from './recursos.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="recursosService">
</bng-form>
`
})
export class RecursosFormComponent extends BngFormBaseComponent {

	constructor(
		activatedRoute: ActivatedRoute,
		public recursosService: RecursosService) {
		super(activatedRoute);
		this.formConfig.readOnlyStateEnabled = false;
	}

}