import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { CpktestService } from './cpktest.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="cpktestService"></bng-form>
`
} )
export class CpktestFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public cpktestService: CpktestService ) { }

}