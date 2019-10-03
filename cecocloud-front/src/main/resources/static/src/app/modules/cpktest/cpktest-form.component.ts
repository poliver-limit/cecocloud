import { Component } from '@angular/core';

import { FormConfig } from '../../shared/restapi-form/restapi-form.component';
import { CpktestService } from './cpktest.service';

@Component( {
    template: `
    <restapi-form
        restapi-form-mant
        [config]="formConfig"
        [restapiService]="cpktestService"></restapi-form>
`
} )
export class CpktestFormComponent {

    formConfig: FormConfig = {
    }

    constructor(
        public cpktestService: CpktestService ) { }

}