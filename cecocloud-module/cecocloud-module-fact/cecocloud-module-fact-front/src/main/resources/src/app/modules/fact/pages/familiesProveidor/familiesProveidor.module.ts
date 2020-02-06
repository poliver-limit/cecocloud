import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { FamiliesProveidorGridComponent } from './familiesProveidor-grid.component';
import { FamiliesProveidorFormComponent } from './familiesProveidor-form.component';
import { FamiliesProveidorService } from './familiesProveidor.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: FamiliesProveidorGridComponent },
            { path: 'create', component: FamiliesProveidorFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: FamiliesProveidorFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        FamiliesProveidorGridComponent,
        FamiliesProveidorFormComponent
    ],
    providers: [
        FamiliesProveidorService
    ]
} )
export class FamiliesProveidorModule {}