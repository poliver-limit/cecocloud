import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { MagatzemsGridComponent } from './magatzems-grid.component';
import { MagatzemsFormComponent } from './magatzems-form.component';
import { MagatzemsService } from './magatzems.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: MagatzemsGridComponent },
            { path: 'create', component: MagatzemsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: MagatzemsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        MagatzemsGridComponent,
        MagatzemsFormComponent
    ],
    providers: [
        MagatzemsService
    ]
} )
export class MagatzemsModule {}