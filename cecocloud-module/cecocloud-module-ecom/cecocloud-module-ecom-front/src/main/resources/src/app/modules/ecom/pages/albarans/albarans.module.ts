import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { AlbaransGridComponent } from './albarans-grid.component';
import { AlbaransFormComponent } from './albarans-form.component';
import { AlbaransService } from './albarans.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: AlbaransGridComponent },
            { path: 'create', component: AlbaransFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: AlbaransFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        AlbaransGridComponent,
        AlbaransFormComponent
    ],
    providers: [
        AlbaransService
    ]
} )
export class AlbaransModule {}