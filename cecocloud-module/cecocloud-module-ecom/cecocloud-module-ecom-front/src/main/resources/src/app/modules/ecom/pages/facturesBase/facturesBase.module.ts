import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { FacturesBaseGridComponent } from './facturesBase-grid.component';
import { FacturesBaseFormComponent } from './facturesBase-form.component';
import { FacturesBaseService } from './facturesBase.service';

import { FacturesBaseFormModule } from './facturesBase-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		FacturesBaseFormModule,
        RouterModule.forChild( [
            { path: '', component: FacturesBaseGridComponent },
            { path: 'create', component: FacturesBaseFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: FacturesBaseFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        FacturesBaseGridComponent        
    ],
    providers: [
        FacturesBaseService
    ]
} )
export class FacturesBaseModule {}