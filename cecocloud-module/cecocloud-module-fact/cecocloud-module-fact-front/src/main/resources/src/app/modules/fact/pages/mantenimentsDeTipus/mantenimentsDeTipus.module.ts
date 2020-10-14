import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { MantenimentsDeTipusGridComponent } from './mantenimentsDeTipus-grid.component';
import { MantenimentsDeTipusFormComponent } from './mantenimentsDeTipus-form.component';
import { MantenimentsDeTipusService } from './mantenimentsDeTipus.service';

import { MantenimentsDeTipusFormModule } from './mantenimentsDeTipus-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		MantenimentsDeTipusFormModule,
        RouterModule.forChild( [
            { path: '', component: MantenimentsDeTipusGridComponent },
            { path: 'create', component: MantenimentsDeTipusFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: MantenimentsDeTipusFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        MantenimentsDeTipusGridComponent        
    ],
    providers: [
        MantenimentsDeTipusService
    ]
} )
export class MantenimentsDeTipusModule {}