import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { SeccionsGrupGridComponent } from './seccionsGrup-grid.component';
import { SeccionsGrupFormComponent } from './seccionsGrup-form.component';
import { SeccionsGrupService } from './seccionsGrup.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: SeccionsGrupGridComponent },
            { path: 'create', component: SeccionsGrupFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: SeccionsGrupFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        SeccionsGrupGridComponent,
        SeccionsGrupFormComponent
    ],
    providers: [
        SeccionsGrupService
    ]
} )
export class SeccionsGrupModule {}