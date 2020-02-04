import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { MagatzemsPeriodeService } from './magatzemsPeriode.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="magatzemsPeriodeService"></bng-form>
`
} )
export class MagatzemsPeriodeFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public magatzemsPeriodeService: MagatzemsPeriodeService ) { }

}