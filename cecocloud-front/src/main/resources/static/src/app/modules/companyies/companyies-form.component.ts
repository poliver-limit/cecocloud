import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { FormConfig } from '../../shared/restapi-form/restapi-form.component';
import { CompanyiesService } from './companyies.service';
import { CompanyiesPermissionService } from './companyies-permission.service';

@Component( {
    template: `
<restapi-form
    restapi-form-mant
    [config]="formConfig"
    [restapiService]="companyiesService">
    <restapi-custom name="codi"></restapi-custom>
    <restapi-custom name="nom"><!--companyia-nom #customField></companyia-nom--></restapi-custom>
    <ng-container *ngIf="id">
        <datagrid
        [config]="permisosDatagridConfig"
        [restapiService]="companyiesPermissionService"></datagrid>
    </ng-container>
</restapi-form>
`
} )
export class CompanyiesFormComponent {

    id: any;

    formConfig: FormConfig = {
    }
    permisosDatagridConfig = {
        adjustHeight: false,
        paginationEnabled: false,
        mode: 'form',
		editable: true
        //columnFiltersEnabled: true
    };

    constructor(
        private activatedRoute: ActivatedRoute,
        public companyiesService: CompanyiesService,
        public companyiesPermissionService: CompanyiesPermissionService ) {
        activatedRoute.params.subscribe(( params ) => {
            if ( params.id ) {
                this.id = params.id;
            }
        } );
        if ( this.id ) {
            companyiesPermissionService.setPermissionResourceId( this.id );
        }
    }

}