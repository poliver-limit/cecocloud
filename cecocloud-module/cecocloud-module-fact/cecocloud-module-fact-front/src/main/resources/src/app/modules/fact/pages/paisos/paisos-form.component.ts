import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { PaisosService } from './paisos.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="paisosService"></bng-form>
`
} )
export class PaisosFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public paisosService: PaisosService ) { }

}