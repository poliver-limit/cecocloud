import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { VehiclesGridComponent } from './vehicles-grid.component';
import { VehiclesFormComponent } from './vehicles-form.component';
import { VehiclesService } from './vehicles.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: VehiclesGridComponent },
            { path: 'create', component: VehiclesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: VehiclesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        VehiclesGridComponent,
        VehiclesFormComponent
    ],
    providers: [
        VehiclesService
    ]
} )
export class VehiclesModule {}