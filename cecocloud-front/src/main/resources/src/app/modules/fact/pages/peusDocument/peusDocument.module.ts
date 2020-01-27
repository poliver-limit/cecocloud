import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { PeusDocumentGridComponent } from './peusDocument-grid.component';
import { PeusDocumentFormComponent } from './peusDocument-form.component';
import { PeusDocumentService } from './peusDocument.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: PeusDocumentGridComponent },
            { path: 'create', component: PeusDocumentFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: PeusDocumentFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        PeusDocumentGridComponent,
        PeusDocumentFormComponent
    ],
    providers: [
        PeusDocumentService
    ]
} )
export class PeusDocumentModule {}