import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TipusVencimentsService } from './tipusVenciments.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tipusVencimentsService"></bng-form>
`
} )
export class TipusVencimentsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tipusVencimentsService: TipusVencimentsService ) { }

}