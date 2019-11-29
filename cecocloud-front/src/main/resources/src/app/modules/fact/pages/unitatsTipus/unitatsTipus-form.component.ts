import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { UnitatsTipusService } from './unitatsTipus.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="unitatsTipusService"></bng-form>
`
} )
export class UnitatsTipusFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public unitatsTipusService: UnitatsTipusService ) { }

}