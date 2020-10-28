import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';
import { EmpresesFactFormComponent } from '../empresesFact/empresesFact-form.component';

import { ExpedientsService } from './expedients.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="expedientsService"></bng-form>
`
} )
export class ExpedientsFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        activatedRoute: ActivatedRoute,
        public expedientsService: ExpedientsService) {
        super(activatedRoute);
        this.setConfigExternalFormComponents([
            { resourceName: 'empresa', component: EmpresesFactFormComponent }
        ]);
    }
}