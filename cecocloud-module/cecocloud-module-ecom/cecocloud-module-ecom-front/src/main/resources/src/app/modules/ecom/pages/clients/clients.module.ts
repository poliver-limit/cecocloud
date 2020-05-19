import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ClientsGridComponent } from './clients-grid.component';
import { ClientsFormComponent } from './clients-form.component';
import { ClientsService } from './clients.service'; // No l'hem posat als Ives

import { ClientsFormModule } from './clients-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		ClientsFormModule,
        RouterModule.forChild( [
            { path: '', component: ClientsGridComponent },
            { path: 'create', component: ClientsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ClientsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ClientsGridComponent        
    ],
    providers: [
        ClientsService
    ]
} )
export class ClientsModule {}