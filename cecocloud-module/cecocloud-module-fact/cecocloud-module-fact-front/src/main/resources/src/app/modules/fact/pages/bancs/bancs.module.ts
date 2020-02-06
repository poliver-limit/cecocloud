import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { BancsGridComponent } from './bancs-grid.component';
import { BancsFormComponent } from './bancs-form.component';
import { BancsService } from './bancs.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: BancsGridComponent },
            { path: 'create', component: BancsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: BancsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        BancsGridComponent,
        BancsFormComponent
    ],
    providers: [
        BancsService
    ]
} )
export class BancsModule {}