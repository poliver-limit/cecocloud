import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { DocumentsPagamentCobramentGridComponent } from './documentsPagamentCobrament-grid.component';
import { DocumentsPagamentCobramentFormComponent } from './documentsPagamentCobrament-form.component';
import { DocumentsPagamentCobramentService } from './documentsPagamentCobrament.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: DocumentsPagamentCobramentGridComponent },
            { path: 'create', component: DocumentsPagamentCobramentFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: DocumentsPagamentCobramentFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        DocumentsPagamentCobramentGridComponent,
        DocumentsPagamentCobramentFormComponent
    ],
    providers: [
        DocumentsPagamentCobramentService
    ]
} )
export class DocumentsPagamentCobramentModule {}