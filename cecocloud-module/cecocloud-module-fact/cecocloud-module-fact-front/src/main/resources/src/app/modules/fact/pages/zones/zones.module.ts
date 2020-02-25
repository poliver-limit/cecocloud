import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ZonesGridComponent } from './zones-grid.component';
import { ZonesFormComponent } from './zones-form.component';
import { ZonesService } from './zones.service';

import { ZonesFormModule } from './zones-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		ZonesFormModule,
        RouterModule.forChild( [
            { path: '', component: ZonesGridComponent },
            { path: 'create', component: ZonesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ZonesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ZonesGridComponent        
    ],
    providers: [
        ZonesService
    ]
} )
export class ZonesModule {}