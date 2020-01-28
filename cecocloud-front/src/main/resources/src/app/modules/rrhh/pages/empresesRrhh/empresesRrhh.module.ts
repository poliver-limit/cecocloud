import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { EmpresesRrhhGridComponent } from './empresesRrhh-grid.component';
import { EmpresesRrhhFormComponent } from './empresesRrhh-form.component';
import { EmpresesRrhhService } from './empresesRrhh.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: EmpresesRrhhGridComponent },
            { path: 'create', component: EmpresesRrhhFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: EmpresesRrhhFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        EmpresesRrhhGridComponent,
        EmpresesRrhhFormComponent
    ],
    providers: [
        EmpresesRrhhService
    ]
} )
export class EmpresesRrhhModule {}