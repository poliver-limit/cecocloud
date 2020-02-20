import { Component } from '@angular/core';
import { BngFormConfig } from 'base-angular';

import { LicitacionsService } from './licitacions.service';

@Component( {
    templateUrl: 'licitacio.html'
})

export class LicitacionsFormComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        public licitacionsService: LicitacionsService ) { }

}