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
import { MagatzemsArticleService } from '../magatzemsArticle/magatzemsArticle.service';

// Per poder recuperar l'empresa de la sessió:
import { BngAuthService } from 'base-angular';
import { EmpresesService } from '../../../../pages/empreses/empreses.service';
import { EmpresesEcomService } from '../empresesEcom/empresesEcom.service';
import { DivisesService } from '../divises/divises.service';

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
		ArticlesTraduccioService,
		MagatzemsArticleService,
		
		BngAuthService,
		EmpresesService,
		EmpresesEcomService,
		DivisesService
    ]
} )
export class ArticlesModule {}