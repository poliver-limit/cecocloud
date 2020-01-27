import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { IntervalsGridComponent } from './intervals-grid.component';
import { IntervalsFormComponent } from './intervals-form.component';
import { IntervalsService } from './intervals.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: IntervalsGridComponent },
            { path: 'create', component: IntervalsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: IntervalsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        IntervalsGridComponent,
        IntervalsFormComponent
    ],
    providers: [
        IntervalsService
    ]
} )
export class IntervalsModule {}