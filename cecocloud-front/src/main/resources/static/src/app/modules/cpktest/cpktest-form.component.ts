import { Component } from '@angular/core';
import { BngFormConfig } from '@programari-limit/bang';

import { CpktestService } from './cpktest.service';

@Component( {
    template: `
    <restapi-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="cpktestService"></restapi-form>
`
} )
export class CpktestFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public cpktestService: CpktestService ) { }

}