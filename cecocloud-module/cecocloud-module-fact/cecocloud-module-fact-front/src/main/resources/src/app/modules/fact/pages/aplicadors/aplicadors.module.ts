import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { AplicadorsGridComponent } from './aplicadors-grid.component';
import { AplicadorsFormComponent } from './aplicadors-form.component';
import { AplicadorsService } from './aplicadors.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: AplicadorsGridComponent },
            { path: 'create', component: AplicadorsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: AplicadorsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        AplicadorsGridComponent,
        AplicadorsFormComponent
    ],
    providers: [
        AplicadorsService
    ]
} )
export class AplicadorsModule {}