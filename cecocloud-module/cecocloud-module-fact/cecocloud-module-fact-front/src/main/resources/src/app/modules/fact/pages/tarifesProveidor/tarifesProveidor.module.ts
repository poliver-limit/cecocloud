import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { TarifesProveidorGridComponent } from './tarifesProveidor-grid.component';
import { TarifesProveidorFormComponent } from './tarifesProveidor-form.component';
import { TarifesProveidorService } from './tarifesProveidor.service';

import { TarifesProveidorFormModule } from './tarifesProveidor-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		TarifesProveidorFormModule,
        RouterModule.forChild( [
            { path: '', component: TarifesProveidorGridComponent },
            { path: 'create', component: TarifesProveidorFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TarifesProveidorFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TarifesProveidorGridComponent        
    ],
    providers: [
        TarifesProveidorService
    ]
} )
export class TarifesProveidorModule {}