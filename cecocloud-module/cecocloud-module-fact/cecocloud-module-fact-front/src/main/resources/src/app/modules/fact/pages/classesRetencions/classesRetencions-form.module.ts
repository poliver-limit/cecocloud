import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ClassesRetencionsFormComponent } from './classesRetencions-form.component';
import { ClassesRetencionsService } from './classesRetencions.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ClassesRetencionsFormComponent
    ],
	entryComponents: [
		ClassesRetencionsFormComponent
	],
	exports: [
		ClassesRetencionsFormComponent
	],
    providers: [
        ClassesRetencionsService
    ]
} )
export class ClassesRetencionsFormModule {}