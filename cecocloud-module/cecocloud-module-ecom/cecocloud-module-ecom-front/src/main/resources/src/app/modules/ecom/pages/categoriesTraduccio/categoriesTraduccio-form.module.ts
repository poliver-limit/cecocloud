import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { CategoriesTraduccioFormComponent } from './categoriesTraduccio-form.component';
import { CategoriesTraduccioService } from './categoriesTraduccio.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        CategoriesTraduccioFormComponent
    ],
	entryComponents: [
		CategoriesTraduccioFormComponent
	],
	exports: [
		CategoriesTraduccioFormComponent
	],
    providers: [
        CategoriesTraduccioService
    ]
} )
export class CategoriesTraduccioFormModule {}