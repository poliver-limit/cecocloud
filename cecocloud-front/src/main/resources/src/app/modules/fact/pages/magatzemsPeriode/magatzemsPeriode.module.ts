import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { MagatzemsPeriodeGridComponent } from './magatzemsPeriode-grid.component';
import { MagatzemsPeriodeFormComponent } from './magatzemsPeriode-form.component';
import { MagatzemsPeriodeService } from './magatzemsPeriode.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: MagatzemsPeriodeGridComponent },
            { path: 'create', component: MagatzemsPeriodeFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: MagatzemsPeriodeFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        MagatzemsPeriodeGridComponent,
        MagatzemsPeriodeFormComponent
    ],
    providers: [
        MagatzemsPeriodeService
    ]
} )
export class MagatzemsPeriodeModule {}