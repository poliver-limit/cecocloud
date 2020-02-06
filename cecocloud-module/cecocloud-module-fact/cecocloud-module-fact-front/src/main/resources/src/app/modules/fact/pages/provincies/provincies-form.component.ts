import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ProvinciesService } from './provincies.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="provinciesService"></bng-form>
`
} )
export class ProvinciesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public provinciesService: ProvinciesService ) { }

}