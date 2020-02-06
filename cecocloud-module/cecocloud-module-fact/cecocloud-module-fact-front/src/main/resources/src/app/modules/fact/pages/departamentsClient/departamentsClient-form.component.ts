import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { DepartamentsClientService } from './departamentsClient.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="departamentsClientService"></bng-form>
`
} )
export class DepartamentsClientFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public departamentsClientService: DepartamentsClientService ) { }

}