import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { SituacionsInicialGridComponent } from './situacionsInicial-grid.component';
import { SituacionsInicialFormComponent } from './situacionsInicial-form.component';
import { SituacionsInicialService } from './situacionsInicial.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: SituacionsInicialGridComponent },
            { path: 'create', component: SituacionsInicialFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: SituacionsInicialFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        SituacionsInicialGridComponent,
        SituacionsInicialFormComponent
    ],
    providers: [
        SituacionsInicialService
    ]
} )
export class SituacionsInicialModule {}