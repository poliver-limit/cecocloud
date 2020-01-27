import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { RegimsGridComponent } from './regims-grid.component';
import { RegimsFormComponent } from './regims-form.component';
import { RegimsService } from './regims.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: RegimsGridComponent },
            { path: 'create', component: RegimsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: RegimsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        RegimsGridComponent,
        RegimsFormComponent
    ],
    providers: [
        RegimsService
    ]
} )
export class RegimsModule {}