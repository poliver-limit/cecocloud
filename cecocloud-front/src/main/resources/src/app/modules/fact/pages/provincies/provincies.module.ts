import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ProvinciesGridComponent } from './provincies-grid.component';
import { ProvinciesFormComponent } from './provincies-form.component';
import { ProvinciesService } from './provincies.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ProvinciesGridComponent },
            { path: 'create', component: ProvinciesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ProvinciesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ProvinciesGridComponent,
        ProvinciesFormComponent
    ],
    providers: [
        ProvinciesService
    ]
} )
export class ProvinciesModule {}