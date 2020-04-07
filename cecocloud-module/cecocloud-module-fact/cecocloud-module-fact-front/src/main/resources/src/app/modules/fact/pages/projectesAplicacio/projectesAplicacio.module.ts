import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ProjectesAplicacioGridComponent } from './projectesAplicacio-grid.component';
import { ProjectesAplicacioFormComponent } from './projectesAplicacio-form.component';
import { ProjectesAplicacioService } from './projectesAplicacio.service';

import { ProjectesAplicacioFormModule } from './projectesAplicacio-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		ProjectesAplicacioFormModule,
        RouterModule.forChild( [
            { path: '', component: ProjectesAplicacioGridComponent },
            { path: 'create', component: ProjectesAplicacioFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ProjectesAplicacioFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ProjectesAplicacioGridComponent        
    ],
    providers: [
        ProjectesAplicacioService
    ]
} )
export class ProjectesAplicacioModule {}