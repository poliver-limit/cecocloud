import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { TipusDiesGridComponent } from './tipusDies-grid.component';
import { TipusDiesFormComponent } from './tipusDies-form.component';
import { TipusDiesService } from './tipusDies.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TipusDiesGridComponent },
            { path: 'create', component: TipusDiesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TipusDiesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TipusDiesGridComponent,
        TipusDiesFormComponent
    ],
    providers: [
        TipusDiesService
    ]
} )
export class TipusDiesModule {}