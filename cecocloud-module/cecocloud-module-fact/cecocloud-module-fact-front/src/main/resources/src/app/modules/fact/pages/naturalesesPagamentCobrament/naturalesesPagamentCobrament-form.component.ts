import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { NaturalesesPagamentCobramentService } from './naturalesesPagamentCobrament.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="naturalesesPagamentCobramentService"></bng-form>
`
} )
export class NaturalesesPagamentCobramentFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public naturalesesPagamentCobramentService: NaturalesesPagamentCobramentService ) { }

}