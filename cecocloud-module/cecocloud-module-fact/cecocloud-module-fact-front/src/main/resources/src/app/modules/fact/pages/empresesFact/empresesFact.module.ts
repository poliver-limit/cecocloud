import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { EmpresesFactGridComponent } from './empresesFact-grid.component';
import { EmpresesFactFormComponent } from './empresesFact-form.component';
import { EmpresesFactService } from './empresesFact.service';

import { EmpresesFactFormModule } from './empresesFact-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		EmpresesFactFormModule,
        RouterModule.forChild( [
            { path: '', component: EmpresesFactGridComponent },
            { path: 'create', component: EmpresesFactFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: EmpresesFactFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        EmpresesFactGridComponent        
    ],
    providers: [
        EmpresesFactService
    ]
} )
export class EmpresesFactModule {}