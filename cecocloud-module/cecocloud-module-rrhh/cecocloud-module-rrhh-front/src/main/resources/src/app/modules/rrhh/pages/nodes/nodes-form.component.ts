import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { NodesService } from './nodes.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="nodesService"></bng-form>
`
} )
export class NodesFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public nodesService: NodesService ) { }

}