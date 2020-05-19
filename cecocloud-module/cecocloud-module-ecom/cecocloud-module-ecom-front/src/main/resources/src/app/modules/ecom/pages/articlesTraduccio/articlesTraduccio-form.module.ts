import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ArticlesTraduccioFormComponent } from './articlesTraduccio-form.component';
import { ArticlesTraduccioService } from './articlesTraduccio.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ArticlesTraduccioFormComponent
    ],
	entryComponents: [
		ArticlesTraduccioFormComponent
	],
	exports: [
		ArticlesTraduccioFormComponent
	],
    providers: [
        ArticlesTraduccioService
    ]
} )
export class ArticlesTraduccioFormModule {}