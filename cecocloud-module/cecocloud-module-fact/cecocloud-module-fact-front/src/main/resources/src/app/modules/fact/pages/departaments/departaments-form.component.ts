import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { DepartamentsService } from './departaments.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="departamentsService"></bng-form>
`
} )
export class DepartamentsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public departamentsService: DepartamentsService ) { }

}