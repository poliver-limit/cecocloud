import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { OperarisService } from './operaris.service';

@Component({
	template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="operarisService">
    </bng-form>
`
})
export class OperarisFormComponent extends BngFormBaseComponent {

	constructor(
		activatedRoute: ActivatedRoute,
		public operarisService: OperarisService) {
		super(activatedRoute);
	}

}