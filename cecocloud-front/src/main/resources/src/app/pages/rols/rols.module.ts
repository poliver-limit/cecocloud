import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { RolsGridComponent } from './rols-grid.component';
import { RolsFormComponent } from './rols-form.component';
import { RolsService } from './rols.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: RolsGridComponent },
            { path: 'create', component: RolsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: RolsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        RolsGridComponent,
        RolsFormComponent
    ],
    providers: [
        RolsService
    ]
} )
export class RolsModule {}