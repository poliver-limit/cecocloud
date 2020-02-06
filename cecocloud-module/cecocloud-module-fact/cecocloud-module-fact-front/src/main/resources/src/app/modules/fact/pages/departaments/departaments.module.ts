import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { DepartamentsGridComponent } from './departaments-grid.component';
import { DepartamentsFormComponent } from './departaments-form.component';
import { DepartamentsService } from './departaments.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: DepartamentsGridComponent },
            { path: 'create', component: DepartamentsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: DepartamentsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        DepartamentsGridComponent,
        DepartamentsFormComponent
    ],
    providers: [
        DepartamentsService
    ]
} )
export class DepartamentsModule {}