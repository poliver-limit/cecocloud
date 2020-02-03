import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TipusDiesService } from './tipusDies.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusDiesService"></bng-form>
`
} )
export class TipusDiesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tipusDiesService: TipusDiesService ) { }

}