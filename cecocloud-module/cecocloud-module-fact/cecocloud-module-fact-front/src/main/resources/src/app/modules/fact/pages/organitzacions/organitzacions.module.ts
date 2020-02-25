import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { OrganitzacionsGridComponent } from './organitzacions-grid.component';
import { OrganitzacionsFormComponent } from './organitzacions-form.component';
import { OrganitzacionsService } from './organitzacions.service';

import { OrganitzacionsFormModule } from './organitzacions-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		OrganitzacionsFormModule,
        RouterModule.forChild( [
            { path: '', component: OrganitzacionsGridComponent },
            { path: 'create', component: OrganitzacionsFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: OrganitzacionsFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        OrganitzacionsGridComponent        
    ],
    providers: [
        OrganitzacionsService
    ]
} )
export class OrganitzacionsModule {}