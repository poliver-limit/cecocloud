import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { EmpresesGrupEmpresesGridComponent } from './empresesGrupEmpreses-grid.component';
import { EmpresesGrupEmpresesFormComponent } from './empresesGrupEmpreses-form.component';
import { EmpresesGrupEmpresesService } from './empresesGrupEmpreses.service';
import { BusinessGroupsFormModule } from '../businessGroups/businessGroups-form.module';
import { EmpresesFactModule } from '../empresesFact/empresesFact.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
        MaterialModule,
        BusinessGroupsFormModule,
        EmpresesFactModule,
        RouterModule.forChild( [
            { path: '', component: EmpresesGrupEmpresesGridComponent },
            { path: 'create', component: EmpresesGrupEmpresesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: EmpresesGrupEmpresesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        EmpresesGrupEmpresesGridComponent,
        EmpresesGrupEmpresesFormComponent
    ],
    providers: [
        EmpresesGrupEmpresesService
    ]
} )
export class EmpresesGrupEmpresesModule {}