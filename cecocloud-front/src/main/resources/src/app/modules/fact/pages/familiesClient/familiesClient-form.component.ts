import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { FamiliesClientService } from './familiesClient.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="familiesClientService"></bng-form>
`
} )
export class FamiliesClientFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public familiesClientService: FamiliesClientService ) { }

}