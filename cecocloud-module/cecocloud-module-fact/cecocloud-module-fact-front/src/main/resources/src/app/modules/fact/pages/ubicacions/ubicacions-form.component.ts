import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { UbicacionsService } from './ubicacions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="ubicacionsService"></bng-form>
`
} )
export class UbicacionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public ubicacionsService: UbicacionsService ) { }

}