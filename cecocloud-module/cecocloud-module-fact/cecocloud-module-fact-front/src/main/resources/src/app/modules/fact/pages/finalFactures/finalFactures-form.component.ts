import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { FinalFacturesService } from './finalFactures.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="finalFacturesService"></bng-form>
`
} )
export class FinalFacturesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public finalFacturesService: FinalFacturesService ) { }

}