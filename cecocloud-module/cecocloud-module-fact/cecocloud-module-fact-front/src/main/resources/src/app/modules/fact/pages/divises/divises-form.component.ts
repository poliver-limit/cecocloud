import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { DivisesService } from './divises.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="divisesService"></bng-form>
`
} )
export class DivisesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public divisesService: DivisesService ) { }

}