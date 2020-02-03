import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { ProjectesTipusService } from './projectesTipus.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="projectesTipusService"></bng-form>
`
} )
export class ProjectesTipusFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public projectesTipusService: ProjectesTipusService ) { }

}