import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { VencimentsGridComponent } from './venciments-grid.component';
import { VencimentsFormComponent } from './venciments-form.component';
import { VencimentsService } from './venciments.service';

import { VencimentsFormModule } from './venciments-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		VencimentsFormModule,
        RouterModule.forChild( [
            { path: '', component: VencimentsGridComponent },
            { path: 'create', component: VencimentsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: VencimentsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        VencimentsGridComponent        
    ],
    providers: [
        VencimentsService
    ]
} )
export class VencimentsModule {}