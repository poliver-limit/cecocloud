import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { IvesGridComponent } from './ives-grid.component';
import { IvesFormComponent } from './ives-form.component';
import { IvesService } from './ives.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: IvesGridComponent },
            { path: 'create', component: IvesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: IvesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        IvesGridComponent,
        IvesFormComponent
    ],
    providers: [
        IvesService
    ]
} )
export class IvesModule {}