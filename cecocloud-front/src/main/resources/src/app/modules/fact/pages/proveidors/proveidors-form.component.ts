import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ProveidorsService } from './proveidors.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="proveidorsService"></bng-form>
`
} )
export class ProveidorsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public proveidorsService: ProveidorsService ) { }

}