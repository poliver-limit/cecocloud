import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { TipusRiscosGridComponent } from './tipusRiscos-grid.component';
import { TipusRiscosFormComponent } from './tipusRiscos-form.component';
import { TipusRiscosService } from './tipusRiscos.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TipusRiscosGridComponent },
            { path: 'create', component: TipusRiscosFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TipusRiscosFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TipusRiscosGridComponent,
        TipusRiscosFormComponent
    ],
    providers: [
        TipusRiscosService
    ]
} )
export class TipusRiscosModule {}