import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ProjectesTipusGridComponent } from './projectesTipus-grid.component';
import { ProjectesTipusFormComponent } from './projectesTipus-form.component';
import { ProjectesTipusService } from './projectesTipus.service';

import { ProjectesTipusFormModule } from './projectesTipus-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		
		ProjectesTipusFormModule,
		
        RouterModule.forChild( [
            { path: '', component: ProjectesTipusGridComponent },
            { path: 'create', component: ProjectesTipusFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ProjectesTipusFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ProjectesTipusGridComponent        
    ],
    providers: [
        ProjectesTipusService
    ]
} )
export class ProjectesTipusModule {}