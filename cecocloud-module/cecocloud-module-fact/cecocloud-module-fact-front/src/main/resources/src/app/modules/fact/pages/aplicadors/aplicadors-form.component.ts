import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { AplicadorsService } from './aplicadors.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="aplicadorsService"></bng-form>
`
} )
export class AplicadorsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public aplicadorsService: AplicadorsService ) { }

}