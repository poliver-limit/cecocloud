import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { UnitatsTipusGridComponent } from './unitatsTipus-grid.component';
import { UnitatsTipusFormComponent } from './unitatsTipus-form.component';
import { UnitatsTipusService } from './unitatsTipus.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: UnitatsTipusGridComponent },
            { path: 'create', component: UnitatsTipusFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: UnitatsTipusFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        UnitatsTipusGridComponent,
        UnitatsTipusFormComponent
    ],
    providers: [
        UnitatsTipusService
    ]
} )
export class UnitatsTipusModule {}