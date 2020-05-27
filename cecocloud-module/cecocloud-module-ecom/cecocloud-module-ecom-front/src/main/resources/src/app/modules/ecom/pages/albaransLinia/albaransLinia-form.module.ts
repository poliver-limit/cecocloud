import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { AlbaransLiniaFormComponent } from './albaransLinia-form.component';
import { AlbaransLiniaService } from './albaransLinia.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        AlbaransLiniaFormComponent
    ],
	entryComponents: [
		AlbaransLiniaFormComponent
	],
	exports: [
		AlbaransLiniaFormComponent
	],
    providers: [
        AlbaransLiniaService
    ]
} )
export class AlbaransLiniaFormModule {}