import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { SituacionsComercialService } from './situacionsComercial.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="situacionsComercialService"></bng-form>
`
} )
export class SituacionsComercialFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public situacionsComercialService: SituacionsComercialService ) { }

}