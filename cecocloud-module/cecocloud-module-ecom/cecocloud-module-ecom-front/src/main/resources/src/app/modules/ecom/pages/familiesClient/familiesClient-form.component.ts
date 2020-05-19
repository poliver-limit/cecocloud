import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';


import { FamiliesClientService } from './familiesClient.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="familiesClientService"></bng-form>
`
} )
export class FamiliesClientFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

     constructor(
		activatedRoute: ActivatedRoute,
        public familiesClientService: FamiliesClientService ) {
			super(activatedRoute);
		}
}