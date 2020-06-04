import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { TipusUnitatsGridComponent } from './tipusUnitats-grid.component';
import { TipusUnitatsFormComponent } from './tipusUnitats-form.component';
import { TipusUnitatsService } from './tipusUnitats.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TipusUnitatsGridComponent },
            { path: 'create', component: TipusUnitatsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TipusUnitatsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TipusUnitatsGridComponent,
        TipusUnitatsFormComponent
    ],
    providers: [
        TipusUnitatsService
    ]
} )
export class TipusUnitatsModule {}