import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { CapitolsGridComponent } from './capitols-grid.component';
import { CapitolsFormComponent } from './capitols-form.component';
import { CapitolsService } from './capitols.service';

import { CapitolsFormModule } from './capitols-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		CapitolsFormModule,
        RouterModule.forChild( [
            { path: '', component: CapitolsGridComponent },
            { path: 'create', component: CapitolsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: CapitolsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        CapitolsGridComponent        
    ],
    providers: [
        CapitolsService
    ]
} )
export class CapitolsModule {}