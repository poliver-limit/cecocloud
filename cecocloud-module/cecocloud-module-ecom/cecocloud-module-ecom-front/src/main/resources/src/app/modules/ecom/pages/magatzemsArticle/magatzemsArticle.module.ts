import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { MagatzemsArticleGridComponent } from './magatzemsArticle-grid.component';
import { MagatzemsArticleFormComponent } from './magatzemsArticle-form.component';
import { MagatzemsArticleService } from './magatzemsArticle.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: MagatzemsArticleGridComponent },
            { path: 'create', component: MagatzemsArticleFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: MagatzemsArticleFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        MagatzemsArticleGridComponent,
        MagatzemsArticleFormComponent
    ],
    providers: [
        MagatzemsArticleService
    ]
} )
export class MagatzemsArticleModule {}