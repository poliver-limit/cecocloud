import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { CpktestGridComponent } from './cpktest-grid.component';
import { CpktestFormComponent } from './cpktest-form.component';
import { CpktestService } from './cpktest.service';

@NgModule( {
    imports: [
        CommonModule,
        BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: CpktestGridComponent },
            { path: 'create', component: CpktestFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: CpktestFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        CpktestGridComponent,
        CpktestFormComponent
    ],
    providers: [
        CpktestService
    ]
} )
export class CpktestModule {}