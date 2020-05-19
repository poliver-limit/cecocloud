import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ArticlesTraduccioGridComponent } from './articlesTraduccio-grid.component';
import { ArticlesTraduccioFormComponent } from './articlesTraduccio-form.component';
import { ArticlesTraduccioService } from './articlesTraduccio.service';

import { ArticlesTraduccioFormModule } from './articlesTraduccio-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		ArticlesTraduccioFormModule,
        RouterModule.forChild( [
            { path: '', component: ArticlesTraduccioGridComponent },
            { path: 'create', component: ArticlesTraduccioFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ArticlesTraduccioFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ArticlesTraduccioGridComponent
    ],
    providers: [
        ArticlesTraduccioService
    ]
} )
export class ArticlesTraduccioModule {}