import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { SubvencionsService } from './subvencions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="subvencionsService"></bng-form>
`
} )
export class SubvencionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public subvencionsService: SubvencionsService ) { }

}