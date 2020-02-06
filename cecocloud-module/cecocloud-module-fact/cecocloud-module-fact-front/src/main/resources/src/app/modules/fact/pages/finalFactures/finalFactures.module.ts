import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { FinalFacturesGridComponent } from './finalFactures-grid.component';
import { FinalFacturesFormComponent } from './finalFactures-form.component';
import { FinalFacturesService } from './finalFactures.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: FinalFacturesGridComponent },
            { path: 'create', component: FinalFacturesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: FinalFacturesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        FinalFacturesGridComponent,
        FinalFacturesFormComponent
    ],
    providers: [
        FinalFacturesService
    ]
} )
export class FinalFacturesModule {}