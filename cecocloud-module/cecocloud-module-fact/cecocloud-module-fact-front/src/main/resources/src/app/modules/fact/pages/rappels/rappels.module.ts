import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { RappelsGridComponent } from './rappels-grid.component';
import { RappelsFormComponent } from './rappels-form.component';
import { RappelsService } from './rappels.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: RappelsGridComponent },
            { path: 'create', component: RappelsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: RappelsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        RappelsGridComponent,
        RappelsFormComponent
    ],
    providers: [
        RappelsService
    ]
} )
export class RappelsModule {}