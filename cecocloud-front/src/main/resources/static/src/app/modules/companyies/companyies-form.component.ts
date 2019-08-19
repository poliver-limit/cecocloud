import { Component } from '@angular/core';

import { FormConfig } from '../../shared/restapi-form/restapi-form.component';
import { CompanyiesService } from './companyies.service';

@Component( {
    template: `
    <restapi-form
        restapi-form-mant
        [config]="formConfig"
        [restapiService]="companyiesService"></restapi-form>
`
} )
export class CompanyiesFormComponent {

    private formConfig: FormConfig = {
    }

    constructor(
        private companyiesService: CompanyiesService ) { }

}