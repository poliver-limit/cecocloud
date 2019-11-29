import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { TipusProveidorsClientGridComponent } from './tipusProveidorsClient-grid.component';
import { TipusProveidorsClientFormComponent } from './tipusProveidorsClient-form.component';
import { TipusProveidorsClientService } from './tipusProveidorsClient.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: TipusProveidorsClientGridComponent },
            { path: 'create', component: TipusProveidorsClientFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: TipusProveidorsClientFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        TipusProveidorsClientGridComponent,
        TipusProveidorsClientFormComponent
    ],
    providers: [
        TipusProveidorsClientService
    ]
} )
export class TipusProveidorsClientModule {}