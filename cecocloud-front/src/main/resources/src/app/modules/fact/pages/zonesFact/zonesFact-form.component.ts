import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ZonesFactService } from './zonesFact.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="zonesFactService"></bng-form>
`
} )
export class ZonesFactFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public zonesFactService: ZonesFactService ) { }

}