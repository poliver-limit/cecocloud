import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { FinalFacturesGridComponent } from './finalFactures-grid.component';
import { FinalFacturesFormComponent } from './finalFactures-form.component';
import { FinalFacturesService } from './finalFactures.service';

import { FinalFacturesFormModule } from './finalFactures-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		FinalFacturesFormModule,
        RouterModule.forChild( [
            { path: '', component: FinalFacturesGridComponent },
            { path: 'create', component: FinalFacturesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: FinalFacturesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        FinalFacturesGridComponent        
    ],
    providers: [
        FinalFacturesService
    ]
} )
export class FinalFacturesModule {}