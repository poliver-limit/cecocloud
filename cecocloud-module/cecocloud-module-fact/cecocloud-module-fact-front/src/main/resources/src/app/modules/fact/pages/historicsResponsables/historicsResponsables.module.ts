import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { HistoricsResponsablesGridComponent } from './historicsResponsables-grid.component';
import { HistoricsResponsablesFormComponent } from './historicsResponsables-form.component';
import { HistoricsResponsablesService } from './historicsResponsables.service';

import { HistoricsResponsablesFormModule } from './historicsResponsables-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		HistoricsResponsablesFormModule,
        RouterModule.forChild( [
            { path: '', component: HistoricsResponsablesGridComponent },
            { path: 'create', component: HistoricsResponsablesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: HistoricsResponsablesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        HistoricsResponsablesGridComponent        
    ],
    providers: [
        HistoricsResponsablesService
    ]
} )
export class HistoricsResponsablesModule {}