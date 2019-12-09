import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { ServidorsGridComponent } from './servidors-grid.component';
import { ServidorsFormComponent } from './servidors-form.component';
import { ServidorsService } from './servidors.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ServidorsGridComponent },
            { path: 'create', component: ServidorsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ServidorsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ServidorsGridComponent,
        ServidorsFormComponent
    ],
    providers: [
        ServidorsService
    ]
} )
export class ServidorsModule {}