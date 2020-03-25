import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ProjectesPressupostGridComponent } from './projectesPressupost-grid.component';
import { ProjectesPressupostFormComponent } from './projectesPressupost-form.component';
import { ProjectesPressupostService } from './projectesPressupost.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ProjectesPressupostGridComponent },
            { path: 'create', component: ProjectesPressupostFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ProjectesPressupostFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ProjectesPressupostGridComponent,
        ProjectesPressupostFormComponent
    ],
    providers: [
        ProjectesPressupostService
    ]
} )
export class ProjectesPressupostModule {}