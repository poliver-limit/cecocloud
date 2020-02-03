import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { GrupsFestiuService } from './grupsFestiu.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="grupsFestiuService"></bng-form>
`
} )
export class GrupsFestiuFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public grupsFestiuService: GrupsFestiuService ) { }

}