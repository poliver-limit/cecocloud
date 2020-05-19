import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { IvesService } from './ives.service';

@Component({
	template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="ivesService"></bng-form>
`
})
export class IvesFormComponent extends BngFormBaseComponent {

	constructor(
		activatedRoute: ActivatedRoute,
		public ivesService: IvesService) {
		super(activatedRoute);
	}

}