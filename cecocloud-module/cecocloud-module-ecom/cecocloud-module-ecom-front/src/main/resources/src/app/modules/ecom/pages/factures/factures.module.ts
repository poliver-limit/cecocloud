import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { FacturesGridComponent } from './factures-grid.component';
import { FacturesFormComponent } from './factures-form.component';

import { FacturesService } from './factures.service';

import { FacturesFormModule } from './factures-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		FacturesFormModule,
        RouterModule.forChild( [
            { path: '', component: FacturesGridComponent },
            { path: 'create', component: FacturesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: FacturesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        FacturesGridComponent        
    ],
    providers: [
        FacturesService	
    ]
} )
export class FacturesModule {}