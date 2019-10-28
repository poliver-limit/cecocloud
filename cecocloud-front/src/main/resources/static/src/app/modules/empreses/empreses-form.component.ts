import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BngFormConfig } from '@programari-limit/bang';

import { EmpresesService } from './empreses.service';
import { EmpresesPermissionService } from './empreses-permission.service';

@Component( {
    template: `
    <bng-form
        bng-form-mant
        [config]="formConfig"
        [restapiService]="empresesService">
        <hr/>
        <br/>
        <h4>Permisos</h4>
        <ng-container *ngIf="id">
            <bng-datagrid
                [config]="permisosDatagridConfig"
                [restapiService]="empresesPermissionService">
            </bng-datagrid>
        </ng-container>
    </bng-form>
`
} )
export class EmpresesFormComponent {

    id: any;

    formConfig: BngFormConfig = {
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