import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { ProveidorsGridComponent } from './proveidors-grid.component';
import { ProveidorsFormComponent } from './proveidors-form.component';
import { ProveidorsService } from './proveidors.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ProveidorsGridComponent },
            { path: 'create', component: ProveidorsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ProveidorsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ProveidorsGridComponent,
        ProveidorsFormComponent
    ],
    providers: [
        ProveidorsService
    ]
} )
export class ProveidorsModule {}