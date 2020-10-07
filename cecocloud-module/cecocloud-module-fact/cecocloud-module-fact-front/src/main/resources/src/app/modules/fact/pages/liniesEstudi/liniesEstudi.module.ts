import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { LiniesEstudiGridComponent } from './liniesEstudi-grid.component';
import { LiniesEstudiFormComponent } from './liniesEstudi-form.component';
import { LiniesEstudiService } from './liniesEstudi.service';
import { EmpresesFactFormModule } from '../empresesFact/empresesFact-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
        MaterialModule,
        EmpresesFactFormModule,
        RouterModule.forChild( [
            { path: '', component: LiniesEstudiGridComponent },
            { path: 'create', component: LiniesEstudiFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: LiniesEstudiFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        LiniesEstudiGridComponent,
        LiniesEstudiFormComponent
    ],
    providers: [
        LiniesEstudiService
    ]
} )
export class LiniesEstudiModule {}