import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { IntervalsService } from './intervals.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="intervalsService"></bng-form>
`
} )
export class IntervalsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public intervalsService: IntervalsService ) { }

}