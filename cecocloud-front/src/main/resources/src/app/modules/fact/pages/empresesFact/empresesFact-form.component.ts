import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { EmpresesFactService } from './empresesFact.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="empresesFactService"></bng-form>
`
} )
export class EmpresesFactFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public empresesFactService: EmpresesFactService ) { }

}