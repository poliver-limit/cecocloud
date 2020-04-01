import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { TornsGridComponent } from './torns-grid.component';
import { TornsFormComponent } from './torns-form.component';
import { TornsService } from './torns.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TornsGridComponent },
            { path: 'create', component: TornsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TornsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TornsGridComponent,
        TornsFormComponent
    ],
    providers: [
        TornsService
    ]
} )
export class TornsModule {}