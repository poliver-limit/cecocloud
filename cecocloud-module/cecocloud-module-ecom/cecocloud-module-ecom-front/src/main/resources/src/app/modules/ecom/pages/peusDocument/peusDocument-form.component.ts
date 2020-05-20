import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { PeusDocumentService } from './peusDocument.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="peusDocumentService"></bng-form>
`
} )
export class PeusDocumentFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public peusDocumentService: PeusDocumentService ) { }

}