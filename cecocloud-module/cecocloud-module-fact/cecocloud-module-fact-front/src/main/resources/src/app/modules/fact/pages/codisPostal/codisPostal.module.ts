import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { CodisPostalGridComponent } from './codisPostal-grid.component';
import { CodisPostalFormComponent } from './codisPostal-form.component';
import { CodisPostalService } from './codisPostal.service';

import { CodisPostalFormModule } from './codisPostal-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		CodisPostalFormModule,
        RouterModule.forChild( [
            { path: '', component: CodisPostalGridComponent },
            { path: 'create', component: CodisPostalFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: CodisPostalFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        CodisPostalGridComponent        
    ],
    providers: [
        CodisPostalService
    ]
} )
export class CodisPostalModule {}