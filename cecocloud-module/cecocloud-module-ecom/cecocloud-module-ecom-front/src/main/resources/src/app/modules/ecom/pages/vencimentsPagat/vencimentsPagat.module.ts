import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { VencimentsPagatGridComponent } from './vencimentsPagat-grid.component';
import { VencimentsPagatFormComponent } from './vencimentsPagat-form.component';
import { VencimentsPagatService } from './vencimentsPagat.service';

import { VencimentsPagatFormModule } from './vencimentsPagat-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		VencimentsPagatFormModule,
        RouterModule.forChild( [
            { path: '', component: VencimentsPagatGridComponent },
            { path: 'create', component: VencimentsPagatFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: VencimentsPagatFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        VencimentsPagatGridComponent        
    ],
    providers: [
        VencimentsPagatService
    ]
} )
export class VencimentsPagatModule {}