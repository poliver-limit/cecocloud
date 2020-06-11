import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { FacturesBaseFormComponent } from './facturesBase-form.component';
import { FacturesBaseService } from './facturesBase.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        FacturesBaseFormComponent
    ],
	entryComponents: [
		FacturesBaseFormComponent
	],
	exports: [
		FacturesBaseFormComponent
	],
    providers: [
        FacturesBaseService
    ]
} )
export class FacturesBaseFormModule {}