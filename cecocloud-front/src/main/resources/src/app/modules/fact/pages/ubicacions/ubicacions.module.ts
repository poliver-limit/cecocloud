import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { UbicacionsGridComponent } from './ubicacions-grid.component';
import { UbicacionsFormComponent } from './ubicacions-form.component';
import { UbicacionsService } from './ubicacions.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: UbicacionsGridComponent },
            { path: 'create', component: UbicacionsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: UbicacionsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        UbicacionsGridComponent,
        UbicacionsFormComponent
    ],
    providers: [
        UbicacionsService
    ]
} )
export class UbicacionsModule {}