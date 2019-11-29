import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { TarifesDescompteService } from './tarifesDescompte.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tarifesDescompteService"></bng-form>
`
} )
export class TarifesDescompteFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public tarifesDescompteService: TarifesDescompteService ) { }

}