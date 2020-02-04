import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { AreaNegocisGridComponent } from './areaNegocis-grid.component';
import { AreaNegocisFormComponent } from './areaNegocis-form.component';
import { AreaNegocisService } from './areaNegocis.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: AreaNegocisGridComponent },
            { path: 'create', component: AreaNegocisFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: AreaNegocisFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        AreaNegocisGridComponent,
        AreaNegocisFormComponent
    ],
    providers: [
        AreaNegocisService
    ]
} )
export class AreaNegocisModule {}