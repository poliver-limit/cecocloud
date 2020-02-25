import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ClientsAdresaGridComponent } from './clientsAdresa-grid.component';
import { ClientsAdresaFormComponent } from './clientsAdresa-form.component';
import { ClientsAdresaService } from './clientsAdresa.service';

import { ClientsAdresaFormModule } from './clientsAdresa-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		ClientsAdresaFormModule,
        RouterModule.forChild( [
            { path: '', component: ClientsAdresaGridComponent },
            { path: 'create', component: ClientsAdresaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ClientsAdresaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ClientsAdresaGridComponent        
    ],
    providers: [
        ClientsAdresaService
    ]
} )
export class ClientsAdresaModule {}