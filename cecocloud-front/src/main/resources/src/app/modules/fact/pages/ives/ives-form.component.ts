import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { IvesService } from './ives.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="ivesService"></bng-form>
`
} )
export class IvesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public ivesService: IvesService ) { }

}