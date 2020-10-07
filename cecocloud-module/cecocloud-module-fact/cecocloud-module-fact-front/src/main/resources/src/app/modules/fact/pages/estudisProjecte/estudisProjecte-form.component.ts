import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormBaseComponent } from 'base-angular';

import { EstudisProjecteService } from './estudisProjecte.service';
import { EmpresesFactFormComponent } from '../empresesFact/empresesFact-form.component'
import { DivisesFormComponent } from '../divises/divises-form.component'

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="estudisProjecteService"></bng-form>
`
} )
export class EstudisProjecteFormComponent extends BngFormBaseComponent{


    constructor(
		activatedRoute: ActivatedRoute,
        public estudisProjecteService: EstudisProjecteService) {
		super(activatedRoute);
		this.setConfigExternalFormComponents([
            { resourceName: 'empresesFact', component: EmpresesFactFormComponent },
            { resourceName: 'divises', component: DivisesFormComponent }
		]);
	}

}