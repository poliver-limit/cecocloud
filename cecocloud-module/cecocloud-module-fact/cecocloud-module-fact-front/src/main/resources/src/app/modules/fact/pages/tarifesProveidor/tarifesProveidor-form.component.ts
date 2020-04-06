import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { TarifesProveidorService } from './tarifesProveidor.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tarifesProveidorService"></bng-form>
`
} )
export class TarifesProveidorFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

     constructor(
		activatedRoute: ActivatedRoute,
        public tarifesProveidorService: TarifesProveidorService ) {
			super(activatedRoute);
		}

}