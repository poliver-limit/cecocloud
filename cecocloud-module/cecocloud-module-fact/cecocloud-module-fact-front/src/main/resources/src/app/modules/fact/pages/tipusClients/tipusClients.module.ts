import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { TipusClientsGridComponent } from './tipusClients-grid.component';
import { TipusClientsFormComponent } from './tipusClients-form.component';
import { TipusClientsService } from './tipusClients.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TipusClientsGridComponent },
            { path: 'create', component: TipusClientsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TipusClientsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TipusClientsGridComponent,
        TipusClientsFormComponent
    ],
    providers: [
        TipusClientsService
    ]
} )
export class TipusClientsModule {}