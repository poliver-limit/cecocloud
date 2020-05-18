import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { TranslateModule } from '@ngx-translate/core';

import { ArticlesInformacioFormComponent } from './articlesInformacio-form.component';
import { ArticlesInformacioService } from './articlesInformacio.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule,
		TranslateModule
    ],
    declarations: [
        ArticlesInformacioFormComponent
    ],
	entryComponents: [
		ArticlesInformacioFormComponent
	],
	exports: [
		ArticlesInformacioFormComponent
	],
    providers: [
        ArticlesInformacioService
    ]
} )
export class ArticlesInformacioFormModule {}