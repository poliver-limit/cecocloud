import { Component } from '@angular/core';

import { FormConfig } from '../../shared/restapi-form/restapi-form.component';
import { CompanyiesService } from './companyies.service';
import { CompanyiesNomFieldComponent } from './companyies-nom-field.component';

@Component( {
    template: `
<restapi-form
    restapi-form-mant
    [config]="formConfig"
    [restapiService]="companyiesService">
    <restapi-custom name="codi"></restapi-custom>
    <restapi-custom name="nom"><!--companyia-nom #customField></companyia-nom--></restapi-custom>
</restapi-form>
`
} )
export class CompanyiesFormComponent {

    formConfig: FormConfig = {
    }

    constructor(
        public companyiesService: CompanyiesService ) { }

}