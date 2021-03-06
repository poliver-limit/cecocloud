import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { TarifesDescompteGridComponent } from './tarifesDescompte-grid.component';
import { TarifesDescompteFormComponent } from './tarifesDescompte-form.component';
import { TarifesDescompteService } from './tarifesDescompte.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TarifesDescompteGridComponent },
            { path: 'create', component: TarifesDescompteFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TarifesDescompteFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TarifesDescompteGridComponent,
        TarifesDescompteFormComponent
    ],
    providers: [
        TarifesDescompteService
    ]
} )
export class TarifesDescompteModule {}