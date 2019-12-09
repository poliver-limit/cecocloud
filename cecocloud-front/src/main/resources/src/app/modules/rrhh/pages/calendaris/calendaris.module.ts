import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { CalendarisGridComponent } from './calendaris-grid.component';
import { CalendarisFormComponent } from './calendaris-form.component';
import { CalendarisService } from './calendaris.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: CalendarisGridComponent },
            { path: 'create', component: CalendarisFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: CalendarisFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        CalendarisGridComponent,
        CalendarisFormComponent
    ],
    providers: [
        CalendarisService
    ]
} )
export class CalendarisModule {}