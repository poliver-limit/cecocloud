import { Component } from '@angular/core';

import { FormConfig } from '../../shared/restapi-form/restapi-form.component';
import { MarcatgesService } from './marcatges.service';

@Component( {
    template: `
    <restapi-form
        restapi-form-mant
        [config]="formConfig"
        [restapiService]="marcatgesService"></restapi-form>
`
} )
export class MarcatgesFormComponent {

    private formConfig: FormConfig = {
    }

    constructor(
        private marcatgesService: MarcatgesService ) { }

}