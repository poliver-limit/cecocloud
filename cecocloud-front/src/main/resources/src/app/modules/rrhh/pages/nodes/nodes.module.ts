import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { NodesGridComponent } from './nodes-grid.component';
import { NodesFormComponent } from './nodes-form.component';
import { NodesService } from './nodes.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: NodesGridComponent },
            { path: 'create', component: NodesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: NodesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        NodesGridComponent,
        NodesFormComponent
    ],
    providers: [
        NodesService
    ]
} )
export class NodesModule {}