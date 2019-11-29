import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { TipusComisionsGridComponent } from './tipusComisions-grid.component';
import { TipusComisionsFormComponent } from './tipusComisions-form.component';
import { TipusComisionsService } from './tipusComisions.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TipusComisionsGridComponent },
            { path: 'create', component: TipusComisionsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TipusComisionsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TipusComisionsGridComponent,
        TipusComisionsFormComponent
    ],
    providers: [
        TipusComisionsService
    ]
} )
export class TipusComisionsModule {}