import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { SubcategoriesGridComponent } from './subcategories-grid.component';
import { SubcategoriesFormComponent } from './subcategories-form.component';
import { SubcategoriesService } from './subcategories.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: SubcategoriesGridComponent },
            { path: 'create', component: SubcategoriesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: SubcategoriesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        SubcategoriesGridComponent,
        SubcategoriesFormComponent
    ],
    providers: [
        SubcategoriesService
    ]
} )
export class SubcategoriesModule {}