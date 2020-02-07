import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { BancsService } from './bancs.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="bancsService"></bng-form>
`
} )
export class BancsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public bancsService: BancsService ) { }

}