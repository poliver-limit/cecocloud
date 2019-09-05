import { Component } from '@angular/core';

import { FormConfig } from '../../shared/restapi-form/restapi-form.component';
import { UsuarisService } from './usuaris.service';

@Component( {
    template: `
    <restapi-form
        restapi-form-mant
        [config]="formConfig"
        [restapiService]="usuarisService"></restapi-form>
`
} )
export class UsuarisFormComponent {

    formConfig: FormConfig = {
    }

    constructor(
        public usuarisService: UsuarisService ) { }

}