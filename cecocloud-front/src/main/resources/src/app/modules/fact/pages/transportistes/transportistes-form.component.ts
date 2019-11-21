import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TransportistesService } from './transportistes.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="transportistesService"></bng-form>
`
} )
export class TransportistesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public transportistesService: TransportistesService ) { }

}