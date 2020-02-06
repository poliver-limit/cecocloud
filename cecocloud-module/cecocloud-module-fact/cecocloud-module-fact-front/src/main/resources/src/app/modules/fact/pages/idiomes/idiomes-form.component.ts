import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { IdiomesService } from './idiomes.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="idiomesService"></bng-form>
`
} )
export class IdiomesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public idiomesService: IdiomesService ) { }

}