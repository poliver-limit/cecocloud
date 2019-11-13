import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { IdentificadorsService } from './identificadors.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="identificadorsService"></bng-form>
`
} )
export class IdentificadorsFormComponent {

    formConfig: BngFormConfig = {}

    constructor(
        public identificadorsService: IdentificadorsService ) {}

}