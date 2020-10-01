import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ParametersGridComponent } from './parameters-grid.component';
import { ParametersFormComponent } from './parameters-form.component';
import { ParametersService } from './parameters.service';

import { ParametersFormModule } from './parameters-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		ParametersFormModule,
        RouterModule.forChild( [
            { path: '', component: ParametersGridComponent },
            { path: 'create', component: ParametersFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ParametersFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ParametersGridComponent        
    ],
    providers: [
        ParametersService
    ]
} )
export class ParametersModule {}