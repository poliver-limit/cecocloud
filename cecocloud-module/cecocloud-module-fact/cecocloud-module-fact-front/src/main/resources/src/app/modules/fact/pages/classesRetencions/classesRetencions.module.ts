import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ClassesRetencionsGridComponent } from './classesRetencions-grid.component';
import { ClassesRetencionsFormComponent } from './classesRetencions-form.component';
import { ClassesRetencionsService } from './classesRetencions.service';

import { ClassesRetencionsFormModule } from './classesRetencions-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		ClassesRetencionsFormModule,
        RouterModule.forChild( [
            { path: '', component: ClassesRetencionsGridComponent },
            { path: 'create', component: ClassesRetencionsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ClassesRetencionsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ClassesRetencionsGridComponent        
    ],
    providers: [
        ClassesRetencionsService
    ]
} )
export class ClassesRetencionsModule {}