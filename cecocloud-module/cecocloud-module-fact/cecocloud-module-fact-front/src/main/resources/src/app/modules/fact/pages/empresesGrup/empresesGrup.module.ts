import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { EmpresesGrupGridComponent } from './empresesGrup-grid.component';
import { EmpresesGrupFormComponent } from './empresesGrup-form.component';
import { EmpresesGrupService } from './empresesGrup.service';
import { GroupsFormModule } from '../groups/groups-form.module';
import { EmpresesFactModule } from '../empresesFact/empresesFact.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
        MaterialModule,
        GroupsFormModule,
        EmpresesFactModule,
        RouterModule.forChild( [
            { path: '', component: EmpresesGrupGridComponent },
            { path: 'create', component: EmpresesGrupFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: EmpresesGrupFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        EmpresesGrupGridComponent,
        EmpresesGrupFormComponent
    ],
    providers: [
        EmpresesGrupService
    ]
} )
export class EmpresesGrupModule {}