import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { UnitatsControlEstudiGridComponent } from './unitatsControlEstudi-grid.component';
import { UnitatsControlEstudiFormComponent } from './unitatsControlEstudi-form.component';
import { UnitatsControlEstudiService } from './unitatsControlEstudi.service';
import { EmpresesFactFormModule } from '../empresesFact/empresesFact-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
        MaterialModule,
        EmpresesFactFormModule,
        RouterModule.forChild( [
            { path: '', component: UnitatsControlEstudiGridComponent },
            { path: 'create', component: UnitatsControlEstudiFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: UnitatsControlEstudiFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        UnitatsControlEstudiGridComponent,
        UnitatsControlEstudiFormComponent
    ],
    providers: [
        UnitatsControlEstudiService
    ]
} )
export class UnitatsControlEstudiModule {}