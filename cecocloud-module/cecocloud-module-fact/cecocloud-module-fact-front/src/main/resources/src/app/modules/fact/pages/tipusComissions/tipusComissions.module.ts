import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { TipusComissionsGridComponent } from './tipusComissions-grid.component';
import { TipusComissionsFormComponent } from './tipusComissions-form.component';
import { TipusComissionsService } from './tipusComissions.service';

import { TipusComissionsFormModule } from './tipusComissions-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		TipusComissionsFormModule,
        RouterModule.forChild( [
            { path: '', component: TipusComissionsGridComponent },
            { path: 'create', component: TipusComissionsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TipusComissionsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TipusComissionsGridComponent        
    ],
    providers: [
        TipusComissionsService
    ]
} )
export class TipusComissionsModule {}