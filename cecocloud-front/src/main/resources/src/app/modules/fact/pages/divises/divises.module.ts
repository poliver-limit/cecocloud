import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { DivisesGridComponent } from './divises-grid.component';
import { DivisesFormComponent } from './divises-form.component';
import { DivisesService } from './divises.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: DivisesGridComponent },
            { path: 'create', component: DivisesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: DivisesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        DivisesGridComponent,
        DivisesFormComponent
    ],
    providers: [
        DivisesService
    ]
} )
export class DivisesModule {}