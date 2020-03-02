import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ProductesFormComponent } from './productes-form.component';
import { ProductesService } from './productes.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ProductesFormComponent
    ],
	entryComponents: [
		ProductesFormComponent
	],
	exports: [
		ProductesFormComponent
	],
    providers: [
        ProductesService
    ]
} )
export class ProductesFormModule {}