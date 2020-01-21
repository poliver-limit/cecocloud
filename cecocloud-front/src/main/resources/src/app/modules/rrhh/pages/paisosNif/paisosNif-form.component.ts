import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { PaisosNifService } from './paisosNif.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="paisosNifService"></bng-form>
`
} )
export class PaisosNifFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public paisosNifService: PaisosNifService ) { }

}