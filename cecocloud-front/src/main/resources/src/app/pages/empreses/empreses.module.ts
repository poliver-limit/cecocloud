import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { EmpresesGridComponent } from './empreses-grid.component';
import { EmpresesFormComponent } from './empreses-form.component';
import { EmpresesService } from './empreses.service';
import { EmpresesPermissionService } from './empreses-permission.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: EmpresesGridComponent },
            { path: 'create', component: EmpresesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: EmpresesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        EmpresesGridComponent,
        EmpresesFormComponent
    ],
    providers: [
        EmpresesService,
        EmpresesPermissionService
    ]
} )
export class EmpresesModule {}