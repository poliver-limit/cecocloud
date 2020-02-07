import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { DepartamentsClientGridComponent } from './departamentsClient-grid.component';
import { DepartamentsClientFormComponent } from './departamentsClient-form.component';
import { DepartamentsClientService } from './departamentsClient.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: DepartamentsClientGridComponent },
            { path: 'create', component: DepartamentsClientFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: DepartamentsClientFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        DepartamentsClientGridComponent,
        DepartamentsClientFormComponent
    ],
    providers: [
        DepartamentsClientService
    ]
} )
export class DepartamentsClientModule {}