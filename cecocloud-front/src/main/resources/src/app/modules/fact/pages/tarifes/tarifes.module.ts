import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { TarifesGridComponent } from './tarifes-grid.component';
import { TarifesFormComponent } from './tarifes-form.component';
import { TarifesService } from './tarifes.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TarifesGridComponent },
            { path: 'create', component: TarifesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TarifesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TarifesGridComponent,
        TarifesFormComponent
    ],
    providers: [
        TarifesService
    ]
} )
export class TarifesModule {}