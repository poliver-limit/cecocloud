import { Component } from '@angular/core';

import { FormConfig } from '../../shared/restapi-form/restapi-form.component';
import { EmpresesService } from './empreses.service';

@Component( {
    template: `
    <restapi-form
        restapi-form-mant
        [config]="formConfig"
        [restapiService]="empresesService"></restapi-form>
`
} )
export class EmpresesFormComponent {

    formConfig: FormConfig = {
    }

    constructor(
        public empresesService: EmpresesService ) { }

}