import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { GroupsGridComponent } from './groups-grid.component';
import { GroupsFormComponent } from './groups-form.component';
import { GroupsService } from './groups.service';

import { GroupsFormModule } from './groups-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		GroupsFormModule,
        RouterModule.forChild( [
            { path: '', component: GroupsGridComponent },
            { path: 'create', component: GroupsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: GroupsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        GroupsGridComponent        
    ],
    providers: [
        GroupsService
    ]
} )
export class GroupsModule {}