import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { RegistresDiariService } from './registresDiari.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="registresDiariService"></bng-form>
`
} )
export class RegistresDiariFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public registresDiariService: RegistresDiariService ) { }

}