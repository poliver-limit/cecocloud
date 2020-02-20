import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';
import { MatCardModule } from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';

import { MaterialModule } from '../../../../shared/material.module';

import { LicitacionsGridComponent } from './licitacions-grid.component';
import { LicitacionsFormComponent } from './licitacions-form.component';
import { LicitacionsService } from './licitacions.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
        MaterialModule,
        MatCardModule,
        MatTableModule,
        RouterModule.forChild( [
            { path: '', component: LicitacionsGridComponent },
            { path: 'create', component: LicitacionsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: LicitacionsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        LicitacionsGridComponent,
        LicitacionsFormComponent
    ],
    providers: [
        LicitacionsService
    ]
} )
export class LicitacionsModule {}