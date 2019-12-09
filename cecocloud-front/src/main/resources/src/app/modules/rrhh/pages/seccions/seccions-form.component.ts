import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { SeccionsService } from './seccions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="seccionsService"></bng-form>
`
} )
export class SeccionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public seccionsService: SeccionsService ) { }

}