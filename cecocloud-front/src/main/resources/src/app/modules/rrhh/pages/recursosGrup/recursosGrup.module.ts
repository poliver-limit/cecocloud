import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { RecursosGrupGridComponent } from './recursosGrup-grid.component';
import { RecursosGrupFormComponent } from './recursosGrup-form.component';
import { RecursosGrupService } from './recursosGrup.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: RecursosGrupGridComponent },
            { path: 'create', component: RecursosGrupFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: RecursosGrupFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        RecursosGrupGridComponent,
        RecursosGrupFormComponent
    ],
    providers: [
        RecursosGrupService
    ]
} )
export class RecursosGrupModule {}