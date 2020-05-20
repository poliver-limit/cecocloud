import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { EmpresesEcomGridComponent } from './empresesEcom-grid.component';
import { EmpresesEcomFormComponent } from './empresesEcom-form.component';
import { EmpresesEcomService } from './empresesEcom.service';

import { EmpresesEcomFormModule } from './empresesEcom-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		EmpresesEcomFormModule,
        RouterModule.forChild( [
            { path: '', component: EmpresesEcomGridComponent },
            { path: 'create', component: EmpresesEcomFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: EmpresesEcomFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        EmpresesEcomGridComponent        
    ],
    providers: [
        EmpresesEcomService
    ]
} )
export class EmpresesEcomModule {}