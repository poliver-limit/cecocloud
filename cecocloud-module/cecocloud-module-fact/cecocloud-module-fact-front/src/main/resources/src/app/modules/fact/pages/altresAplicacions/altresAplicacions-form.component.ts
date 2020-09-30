import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { AltresAplicacionsService } from './altresAplicacions.service';
import { TransportistesFormComponent } from '../transportistes/transportistes-form.component'

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="altresAplicacionsService"></bng-form>
`
} )
export class AltresAplicacionsFormComponent extends BngFormBaseComponent{

    constructor(
        activatedRoute: ActivatedRoute,
        public altresAplicacionsService: AltresAplicacionsService ) { super(activatedRoute);
            this.setConfigExternalFormComponents([
                { resourceName: 'transportista', component: TransportistesFormComponent }
            ]);
        }

}