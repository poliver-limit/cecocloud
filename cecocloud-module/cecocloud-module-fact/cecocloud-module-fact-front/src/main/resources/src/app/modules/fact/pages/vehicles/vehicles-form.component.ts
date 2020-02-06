import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { VehiclesService } from './vehicles.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="vehiclesService"></bng-form>
`
} )
export class VehiclesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public vehiclesService: VehiclesService ) { }

}