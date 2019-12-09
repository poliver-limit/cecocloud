import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { EmpresesService } from './empreses.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="empresesService"></bng-form>
`
} )
export class EmpresesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public empresesService: EmpresesService ) { }

}