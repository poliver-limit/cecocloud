import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { MagatzemsService } from './magatzems.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="magatzemsService"></bng-form>
`
} )
export class MagatzemsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public magatzemsService: MagatzemsService ) { }

}