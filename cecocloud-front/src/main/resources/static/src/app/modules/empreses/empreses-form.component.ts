import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { FormConfig } from '../../shared/restapi-form/restapi-form.component';
import { EmpresesService } from './empreses.service';
import { EmpresesPermissionService } from './empreses-permission.service';

@Component( {
    template: `
    <restapi-form
        restapi-form-mant
        [config]="formConfig"
        [restapiService]="empresesService">
        <hr/>
        <br/>
        <h4>Permisos</h4>
        <ng-container *ngIf="id">
            <datagrid
                [config]="permisosDatagridConfig"
                [restapiService]="empresesPermissionService">
            </datagrid>
        </ng-container>
    </restapi-form>
`
} )
export class EmpresesFormComponent {

    id: any;

    formConfig: FormConfig = {
    }
    permisosDatagridConfig = {
        //columnFiltersEnabled: true
        adjustHeight: false,
        paginationEnabled: false,
        mode: 'form',
		editable: true,
		columns: [{
            field: 'sidType',
			width: 30
        }, {
            field: 'sidName',
			width: 40
        }, {
            field: 'adminGranted',
			width: 10
        }]
    };

    constructor(
        activatedRoute: ActivatedRoute,
        public empresesService: EmpresesService,
        public empresesPermissionService: EmpresesPermissionService ) { 
            activatedRoute.params.subscribe(( params ) => {
                if ( params.id ) {
                    this.id = params.id;
                }
            } );
            if ( this.id ) {
                empresesPermissionService.setPermissionResourceId( this.id );
            }
    }

}