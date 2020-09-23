import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { AltresAplicacionsGridComponent } from './altresAplicacions-grid.component';
import { AltresAplicacionsFormComponent } from './altresAplicacions-form.component';
import { AltresAplicacionsService } from './altresAplicacions.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: AltresAplicacionsGridComponent },
            { path: 'create', component: AltresAplicacionsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: AltresAplicacionsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        AltresAplicacionsGridComponent,
        AltresAplicacionsFormComponent
    ],
    providers: [
        AltresAplicacionsService
    ]
} )
export class AltresAplicacionsModule {}