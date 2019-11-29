import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { SubvencionsGridComponent } from './subvencions-grid.component';
import { SubvencionsFormComponent } from './subvencions-form.component';
import { SubvencionsService } from './subvencions.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: SubvencionsGridComponent },
            { path: 'create', component: SubvencionsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: SubvencionsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        SubvencionsGridComponent,
        SubvencionsFormComponent
    ],
    providers: [
        SubvencionsService
    ]
} )
export class SubvencionsModule {}