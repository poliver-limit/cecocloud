import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ArticlesGridComponent } from './articles-grid.component';
import { ArticlesFormComponent } from './articles-form.component';
import { ArticlesService } from './articles.service';
import { IvesFormModule } from '../ives/ives-form.module';
//import { ArticlesInformacioFormModule } from '../articlesInformacio/articlesInformacio-form.module';

import { ArticlesFormModule } from './articles-form.module';

import { ArticlesInformacioService } from '../articlesInformacio/articlesInformacio.service';
import { ArticlesTraduccioService } from '../articlesTraduccio/articlesTraduccio.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		
		ArticlesFormModule,
		
		IvesFormModule,
//		ArticlesInformacioFormModule,
        RouterModule.forChild( [
            { path: '', component: ArticlesGridComponent },
            { path: 'create', component: ArticlesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ArticlesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ArticlesGridComponent
//		,ArticlesFormComponent
    ],
    providers: [
        ArticlesService,

		ArticlesInformacioService,
		ArticlesTraduccioService
    ]
} )
export class ArticlesModule {}