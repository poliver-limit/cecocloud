import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { FamiliesCostGridComponent } from './familiesCost-grid.component';
import { FamiliesCostFormComponent } from './familiesCost-form.component';
import { FamiliesCostService } from './familiesCost.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: FamiliesCostGridComponent },
            { path: 'create', component: FamiliesCostFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: FamiliesCostFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        FamiliesCostGridComponent,
        FamiliesCostFormComponent
    ],
    providers: [
        FamiliesCostService
    ]
} )
export class FamiliesCostModule {}