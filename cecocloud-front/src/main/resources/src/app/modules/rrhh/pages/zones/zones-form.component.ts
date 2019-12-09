import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ZonesService } from './zones.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="zonesService"></bng-form>
`
} )
export class ZonesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public zonesService: ZonesService ) { }

}