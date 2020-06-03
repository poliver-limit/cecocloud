import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';
import { TranslateModule } from '@ngx-translate/core';

import { ArticlesInformacioService } from '../articlesInformacio/articlesInformacio.service';
import { ArticlesTraduccioService } from '../articlesTraduccio/articlesTraduccio.service';

import { ArticlesFormComponent } from './articles-form.component';
import { ArticlesService } from './articles.service';

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
		ArticlesTraduccioService		
    ]
} )
export class ArticlesFormModule {}