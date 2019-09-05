import { Component } from '@angular/core';

import { FormConfig } from '../../shared/restapi-form/restapi-form.component';
import { OperarisService } from './operaris.service';

@Component( {
    template: `
    <restapi-form
        restapi-form-mant
        [config]="formConfig"
        [restapiService]="operarisService"></restapi-form>
`
} )
export class OperarisFormComponent {

    formConfig: FormConfig = {
    }

    constructor(
        public operarisService: OperarisService ) { }

}