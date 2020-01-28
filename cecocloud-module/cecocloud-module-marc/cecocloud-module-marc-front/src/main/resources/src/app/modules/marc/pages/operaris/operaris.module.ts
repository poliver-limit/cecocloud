import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { OperarisGridComponent } from './operaris-grid.component';
import { OperarisFormComponent } from './operaris-form.component';
import { OperarisService } from './operaris.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: OperarisGridComponent },
            { path: 'create', component: OperarisFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: OperarisFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        OperarisGridComponent,
        OperarisFormComponent
    ],
    providers: [
        OperarisService
    ]
} )
export class OperarisModule {}