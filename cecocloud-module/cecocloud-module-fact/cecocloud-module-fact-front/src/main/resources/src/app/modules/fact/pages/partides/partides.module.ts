import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { PartidesGridComponent } from './partides-grid.component';
import { PartidesFormComponent } from './partides-form.component';
import { PartidesService } from './partides.service';

import { PartidesFormModule } from './partides-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		PartidesFormModule,
        RouterModule.forChild( [
            { path: '', component: PartidesGridComponent },
            { path: 'create', component: PartidesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: PartidesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        PartidesGridComponent        
    ],
    providers: [
        PartidesService
    ]
} )
export class PartidesModule {}