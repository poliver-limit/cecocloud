import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { TipusVencimentsService } from './tipusVenciments.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusVencimentsService"></bng-form>
`
} )
export class TipusVencimentsFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public tipusVencimentsService: TipusVencimentsService ) {
			super(activatedRoute);
		}
}