import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig, BngFormBaseComponent } from 'base-angular';
import { EmpresesFactFormComponent } from '../empresesFact/empresesFact-form.component';
import { MagatzemsFormComponent } from '../magatzems/magatzems-form.component';
import { ProjectesFormComponent } from '../projectes/projectes-form.component';

import { TallersService } from './tallers.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="tallersService"></bng-form>
`
} )
export class TallersFormComponent extends BngFormBaseComponent {

    formConfig: BngFormConfig = {
    }

    constructor(
        activatedRoute: ActivatedRoute,
        public tallersService: TallersService) {
        super(activatedRoute);
        this.setConfigExternalFormComponents([
            { resourceName: 'empresa', component: EmpresesFactFormComponent },
            { resourceName: 'projecte', component: ProjectesFormComponent },
            { resourceName: 'magatzem', component: MagatzemsFormComponent }
        ]);
    }
}