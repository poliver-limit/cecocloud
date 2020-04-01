import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TornsService } from './torns.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tornsService"></bng-form>
`
} )
export class TornsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tornsService: TornsService ) { }

}