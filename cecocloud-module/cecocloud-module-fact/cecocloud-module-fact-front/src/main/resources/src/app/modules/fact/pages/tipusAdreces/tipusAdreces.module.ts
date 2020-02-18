import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { TipusAdrecesGridComponent } from './tipusAdreces-grid.component';
import { TipusAdrecesFormComponent } from './tipusAdreces-form.component';
import { TipusAdrecesService } from './tipusAdreces.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TipusAdrecesGridComponent },
            { path: 'create', component: TipusAdrecesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TipusAdrecesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TipusAdrecesGridComponent,
        TipusAdrecesFormComponent
    ],
    providers: [
        TipusAdrecesService
    ]
} )
export class TipusAdrecesModule {}