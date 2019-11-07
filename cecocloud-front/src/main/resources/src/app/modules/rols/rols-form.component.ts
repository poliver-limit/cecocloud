import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { RolsService } from './rols.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="rolsService"></bng-form>
`
} )
export class RolsFormComponent {

    formConfig: BngFormConfig = {}

    constructor(
        public rolsService: RolsService ) {}

}