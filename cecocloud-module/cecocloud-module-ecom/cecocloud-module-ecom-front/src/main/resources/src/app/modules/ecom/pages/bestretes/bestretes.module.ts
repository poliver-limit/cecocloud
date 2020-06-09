import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { BestretesGridComponent } from './bestretes-grid.component';
import { BestretesFormComponent } from './bestretes-form.component';
import { BestretesService } from './bestretes.service';

import { BestretesFormModule } from './bestretes-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		BestretesFormModule,
        RouterModule.forChild( [
            { path: '', component: BestretesGridComponent },
            { path: 'create', component: BestretesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: BestretesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        BestretesGridComponent        
    ],
    providers: [
        BestretesService
    ]
} )
export class BestretesModule {}