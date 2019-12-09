import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { HorarisGridComponent } from './horaris-grid.component';
import { HorarisFormComponent } from './horaris-form.component';
import { HorarisService } from './horaris.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: HorarisGridComponent },
            { path: 'create', component: HorarisFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: HorarisFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        HorarisGridComponent,
        HorarisFormComponent
    ],
    providers: [
        HorarisService
    ]
} )
export class HorarisModule {}