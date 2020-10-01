import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { UsuarisGrupGridComponent } from './usuarisGrup-grid.component';
import { UsuarisGrupFormComponent } from './usuarisGrup-form.component';
import { UsuarisGrupService } from './usuarisGrup.service';
import { GroupsFormModule } from '../groups/groups-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
        MaterialModule,
        GroupsFormModule,
        RouterModule.forChild( [
            { path: '', component: UsuarisGrupGridComponent },
            { path: 'create', component: UsuarisGrupFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: UsuarisGrupFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        UsuarisGrupGridComponent,
        UsuarisGrupFormComponent
    ],
    providers: [
        UsuarisGrupService
    ]
} )
export class UsuarisGrupModule {}