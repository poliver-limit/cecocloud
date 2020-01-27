import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ZonesGridComponent } from './zones-grid.component';
import { ZonesFormComponent } from './zones-form.component';
import { ZonesService } from './zones.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ZonesGridComponent },
            { path: 'create', component: ZonesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ZonesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ZonesGridComponent,
        ZonesFormComponent
    ],
    providers: [
        ZonesService
    ]
} )
export class ZonesModule {}