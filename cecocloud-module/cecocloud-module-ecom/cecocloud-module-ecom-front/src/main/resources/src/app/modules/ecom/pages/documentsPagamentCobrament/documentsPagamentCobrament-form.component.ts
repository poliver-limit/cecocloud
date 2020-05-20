import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';

import { DocumentsPagamentCobramentService } from './documentsPagamentCobrament.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="documentsPagamentCobramentService"></bng-form>
`
} )
export class DocumentsPagamentCobramentFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
		activatedRoute: ActivatedRoute,
        public documentsPagamentCobramentService: DocumentsPagamentCobramentService ) {
			super(activatedRoute);
		}
}