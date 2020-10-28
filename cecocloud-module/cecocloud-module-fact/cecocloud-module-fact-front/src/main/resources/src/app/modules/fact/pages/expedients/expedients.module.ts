import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ExpedientsGridComponent } from './expedients-grid.component';
import { ExpedientsFormComponent } from './expedients-form.component';
import { ExpedientsService } from './expedients.service';

import { ExpedientsFormModule } from './expedients-form.module';
import { EmpresesFactFormModule } from '../empresesFact/empresesFact-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        ExpedientsFormModule,
        EmpresesFactFormModule,
        RouterModule.forChild( [
            { path: '', component: ExpedientsGridComponent },
            { path: 'create', component: ExpedientsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ExpedientsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ExpedientsGridComponent        
    ],
    providers: [
        ExpedientsService
    ]
} )
export class ExpedientsModule {}