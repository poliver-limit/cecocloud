import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { FamiliesClientGridComponent } from './familiesClient-grid.component';
import { FamiliesClientFormComponent } from './familiesClient-form.component';
import { FamiliesClientService } from './familiesClient.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: FamiliesClientGridComponent },
            { path: 'create', component: FamiliesClientFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: FamiliesClientFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        FamiliesClientGridComponent,
        FamiliesClientFormComponent
    ],
    providers: [
        FamiliesClientService
    ]
} )
export class FamiliesClientModule {}