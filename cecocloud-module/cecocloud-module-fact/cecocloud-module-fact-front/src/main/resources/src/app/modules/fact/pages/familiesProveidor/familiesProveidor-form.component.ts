import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { FamiliesProveidorService } from './familiesProveidor.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="familiesProveidorService"></bng-form>
`
} )
export class FamiliesProveidorFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public familiesProveidorService: FamiliesProveidorService ) { }

}