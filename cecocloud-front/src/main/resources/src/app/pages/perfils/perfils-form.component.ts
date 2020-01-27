import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig } from 'base-angular';

import { PerfilsService } from './perfils.service';

@Component({
	template: `
		<bng-form
		    bng-form-mant
		    [config]="formConfig"
		    [restapiService]="perfilsService">
			<ng-container *ngIf="id">
				<cec-funcionalitats
					[perfil] = "id">
				</cec-funcionalitats>
			</ng-container>
		</bng-form>
	`
})
export class PerfilsFormComponent {

	id: any;
	formConfig: BngFormConfig = {}

	constructor(
		activatedRoute: ActivatedRoute,
		public perfilsService: PerfilsService) {
		activatedRoute.params.subscribe((params) => {
			if (params.id) {
				this.id = params.id;
			}
		});
	}

}