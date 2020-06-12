import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { VencimentsFormComponent } from './venciments-form.component';
import { VencimentsService } from './venciments.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        VencimentsFormComponent
    ],
	entryComponents: [
		VencimentsFormComponent
	],
	exports: [
		VencimentsFormComponent
	],
    providers: [
        VencimentsService
    ]
} )
export class VencimentsFormModule {}