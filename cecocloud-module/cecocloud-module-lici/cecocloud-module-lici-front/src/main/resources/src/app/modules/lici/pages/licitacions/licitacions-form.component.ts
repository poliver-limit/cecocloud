import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { LicitacionsService } from './licitacions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="licitacionsService"></bng-form>
`
} )
export class LicitacionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public licitacionsService: LicitacionsService ) { }

}