import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { AltresAplicacionsService } from './altresAplicacions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="altresAplicacionsService"></bng-form>
`
} )
export class AltresAplicacionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public altresAplicacionsService: AltresAplicacionsService ) { }

}