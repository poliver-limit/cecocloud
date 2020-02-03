import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ZonesRrhhService } from './zonesRrhh.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="zonesRrhhService"></bng-form>
`
} )
export class ZonesRrhhFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public zonesRrhhService: ZonesRrhhService ) { }

}