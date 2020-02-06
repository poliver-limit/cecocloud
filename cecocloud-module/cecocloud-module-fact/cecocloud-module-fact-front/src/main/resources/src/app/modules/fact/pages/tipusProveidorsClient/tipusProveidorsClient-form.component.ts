import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TipusProveidorsClientService } from './tipusProveidorsClient.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusProveidorsClientService"></bng-form>
`
} )
export class TipusProveidorsClientFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tipusProveidorsClientService: TipusProveidorsClientService ) { }

}