import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { NaturalesesPagamentCobramentGridComponent } from './naturalesesPagamentCobrament-grid.component';
import { NaturalesesPagamentCobramentFormComponent } from './naturalesesPagamentCobrament-form.component';
import { NaturalesesPagamentCobramentService } from './naturalesesPagamentCobrament.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: NaturalesesPagamentCobramentGridComponent },
            { path: 'create', component: NaturalesesPagamentCobramentFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: NaturalesesPagamentCobramentFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        NaturalesesPagamentCobramentGridComponent,
        NaturalesesPagamentCobramentFormComponent
    ],
    providers: [
        NaturalesesPagamentCobramentService
    ]
} )
export class NaturalesesPagamentCobramentModule {}