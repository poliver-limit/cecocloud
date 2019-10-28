import { Component } from '@angular/core';
import { BngFormConfig } from '@programari-limit/bang';

import { OperarisService } from './operaris.service';

@Component( {
    template: `
    <bng-form
        restapi-form-mant
        [config]="formConfig"
        [restapiService]="operarisService"></bng-form>
`
} )
export class OperarisFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public operarisService: OperarisService ) { }

}