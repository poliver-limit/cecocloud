import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { BusinessGroupsGridComponent } from './businessGroups-grid.component';
import { BusinessGroupsFormComponent } from './businessGroups-form.component';
import { BusinessGroupsService } from './businessGroups.service';

import { BusinessGroupsFormModule } from './businessGroups-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		BusinessGroupsFormModule,
        RouterModule.forChild( [
            { path: '', component: BusinessGroupsGridComponent },
            { path: 'create', component: BusinessGroupsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: BusinessGroupsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        BusinessGroupsGridComponent        
    ],
    providers: [
        BusinessGroupsService
    ]
} )
export class BusinessGroupsModule {}