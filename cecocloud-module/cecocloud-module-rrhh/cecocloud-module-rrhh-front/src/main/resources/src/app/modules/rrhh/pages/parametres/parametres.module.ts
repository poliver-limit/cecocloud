import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ParametresGridComponent } from './parametres-grid.component';
import { ParametresFormComponent } from './parametres-form.component';
import { ParametresService } from './parametres.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ParametresGridComponent },
            { path: 'create', component: ParametresFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ParametresFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ParametresGridComponent,
        ParametresFormComponent
    ],
    providers: [
        ParametresService
    ]
} )
export class ParametresModule {}