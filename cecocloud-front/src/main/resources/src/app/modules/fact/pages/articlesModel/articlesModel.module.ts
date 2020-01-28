import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ArticlesModelGridComponent } from './articlesModel-grid.component';
import { ArticlesModelFormComponent } from './articlesModel-form.component';
import { ArticlesModelService } from './articlesModel.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ArticlesModelGridComponent },
            { path: 'create', component: ArticlesModelFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ArticlesModelFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ArticlesModelGridComponent,
        ArticlesModelFormComponent
    ],
    providers: [
        ArticlesModelService
    ]
} )
export class ArticlesModelModule {}