import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { AplicadorsClientService } from './aplicadorsClient.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="aplicadorsClientService"></bng-form>
`
} )
export class AplicadorsClientFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public aplicadorsClientService: AplicadorsClientService ) { }

}