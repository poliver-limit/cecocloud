import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { FamiliesCostService } from './familiesCost.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="familiesCostService"></bng-form>
`
} )
export class FamiliesCostFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public familiesCostService: FamiliesCostService ) { }

}