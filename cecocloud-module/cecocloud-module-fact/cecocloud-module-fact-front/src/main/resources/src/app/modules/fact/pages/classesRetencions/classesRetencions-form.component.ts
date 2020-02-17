import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ClassesRetencionsService } from './classesRetencions.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="classesRetencionsService"></bng-form>
`
} )
export class ClassesRetencionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public classesRetencionsService: ClassesRetencionsService ) { }

}