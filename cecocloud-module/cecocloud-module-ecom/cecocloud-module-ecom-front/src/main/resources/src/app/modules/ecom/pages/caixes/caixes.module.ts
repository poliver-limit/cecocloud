import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { CaixesGridComponent } from './caixes-grid.component';
import { CaixesFormComponent } from './caixes-form.component';
import { CaixesService } from './caixes.service';

import { CaixesFormModule } from './caixes-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		CaixesFormModule,
        RouterModule.forChild( [
            { path: '', component: CaixesGridComponent },
            { path: 'create', component: CaixesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: CaixesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        CaixesGridComponent        
    ],
    providers: [
        CaixesService
    ]
} )
export class CaixesModule {}