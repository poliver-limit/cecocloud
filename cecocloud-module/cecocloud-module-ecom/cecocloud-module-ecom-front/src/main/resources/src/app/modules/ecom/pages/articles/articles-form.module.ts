import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';
import { TranslateModule } from '@ngx-translate/core';

import { ArticlesInformacioService } from '../articlesInformacio/articlesInformacio.service';
import { ArticlesTraduccioService } from '../articlesTraduccio/articlesTraduccio.service';
import { MagatzemsArticleService } from '../magatzemsArticle/magatzemsArticle.service';

import { ArticlesFormComponent } from './articles-form.component';
import { ArticlesService } from './articles.service';

// Per poder recuperar l'empresa de la sessió:
import { BngAuthService } from 'base-angular';
import { EmpresesService } from '../../../../pages/empreses/empreses.service';
import { EmpresesEcomService } from '../empresesEcom/empresesEcom.service';
import { DivisesService } from '../divises/divises.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule,
		MaterialModule,
		TranslateModule
    ],
    declarations: [
        ArticlesFormComponent
    ],
	entryComponents: [
		ArticlesFormComponent
	],
	exports: [
		ArticlesFormComponent
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
export class ArticlesFormModule {}