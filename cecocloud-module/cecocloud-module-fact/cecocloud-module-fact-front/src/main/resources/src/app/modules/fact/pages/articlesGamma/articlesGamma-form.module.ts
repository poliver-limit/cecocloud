import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ArticlesGammaFormComponent } from './articlesGamma-form.component';
import { ArticlesGammaService } from './articlesGamma.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ArticlesGammaFormComponent
    ],
	entryComponents: [
		ArticlesGammaFormComponent
	],
	exports: [
		ArticlesGammaFormComponent
	],
    providers: [
        ArticlesGammaService
    ]
} )
export class ArticlesGammaFormModule {}