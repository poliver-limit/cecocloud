import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { ZonesFactGridComponent } from './zonesFact-grid.component';
import { ZonesFactFormComponent } from './zonesFact-form.component';
import { ZonesFactService } from './zonesFact.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ZonesFactGridComponent },
            { path: 'create', component: ZonesFactFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ZonesFactFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ZonesFactGridComponent,
        ZonesFactFormComponent
    ],
    providers: [
        ZonesFactService
    ]
} )
export class ZonesFactModule {}