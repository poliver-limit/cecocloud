import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { CategoriesGridComponent } from './categories-grid.component';
import { CategoriesFormComponent } from './categories-form.component';
import { CategoriesService } from './categories.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: CategoriesGridComponent },
            { path: 'create', component: CategoriesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: CategoriesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        CategoriesGridComponent,
        CategoriesFormComponent
    ],
    providers: [
        CategoriesService
    ]
} )
export class CategoriesModule {}