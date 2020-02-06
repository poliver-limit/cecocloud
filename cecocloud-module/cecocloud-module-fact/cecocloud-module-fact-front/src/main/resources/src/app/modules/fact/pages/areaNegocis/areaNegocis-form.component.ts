import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { AreaNegocisService } from './areaNegocis.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="areaNegocisService"></bng-form>
`
} )
export class AreaNegocisFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public areaNegocisService: AreaNegocisService ) { }

}