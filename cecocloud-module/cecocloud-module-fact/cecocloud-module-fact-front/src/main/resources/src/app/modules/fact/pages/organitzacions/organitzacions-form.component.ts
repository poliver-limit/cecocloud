import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { OrganitzacionsService } from './organitzacions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="organitzacionsService"></bng-form>
`
} )
export class OrganitzacionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public organitzacionsService: OrganitzacionsService ) { }

}