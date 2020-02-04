import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { DocumentsPagamentCobramentService } from './documentsPagamentCobrament.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="documentsPagamentCobramentService"></bng-form>
`
} )
export class DocumentsPagamentCobramentFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public documentsPagamentCobramentService: DocumentsPagamentCobramentService ) { }

}