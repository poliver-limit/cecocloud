import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { AlbaransService } from './albarans.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="albaransService"></bng-form>
`
} )
export class AlbaransFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public albaransService: AlbaransService ) { }

}