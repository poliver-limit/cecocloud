import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { RegistresComercialsGridComponent } from './registresComercials-grid.component';
import { RegistresComercialsFormComponent } from './registresComercials-form.component';
import { RegistresComercialsService } from './registresComercials.service';

import { ClientsFormModule } from '../clients/clients-form.module'

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		ClientsFormModule,
        RouterModule.forChild( [
            { path: '', component: RegistresComercialsGridComponent },
            { path: 'create', component: RegistresComercialsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: RegistresComercialsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        RegistresComercialsGridComponent,
        RegistresComercialsFormComponent
    ],
    providers: [
        RegistresComercialsService
    ]
} )
export class RegistresComercialsModule {}