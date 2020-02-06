import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { AplicadorsClientGridComponent } from './aplicadorsClient-grid.component';
import { AplicadorsClientFormComponent } from './aplicadorsClient-form.component';
import { AplicadorsClientService } from './aplicadorsClient.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: AplicadorsClientGridComponent },
            { path: 'create', component: AplicadorsClientFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: AplicadorsClientFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        AplicadorsClientGridComponent,
        AplicadorsClientFormComponent
    ],
    providers: [
        AplicadorsClientService
    ]
} )
export class AplicadorsClientModule {}