import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { HorarisService } from './horaris.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="horarisService"></bng-form>
`
} )
export class HorarisFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public horarisService: HorarisService ) { }

}