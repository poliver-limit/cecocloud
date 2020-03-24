import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ProjectesTipusFormComponent } from './projectesTipus-form.component';
import { ProjectesTipusService } from './projectesTipus.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ProjectesTipusFormComponent
    ],
	entryComponents: [
		ProjectesTipusFormComponent
	],
	exports: [
		ProjectesTipusFormComponent
	],
    providers: [
        ProjectesTipusService
    ]
} )
export class ProjectesTipusFormModule {}