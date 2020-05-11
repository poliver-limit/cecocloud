import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ArticlesInformacioFormComponent } from './articlesInformacio-form.component';
import { ArticlesInformacioService } from './articlesInformacio.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
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