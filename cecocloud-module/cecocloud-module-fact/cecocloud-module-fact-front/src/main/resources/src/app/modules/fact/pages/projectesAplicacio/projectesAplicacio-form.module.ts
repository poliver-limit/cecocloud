import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ProjectesAplicacioFormComponent } from './projectesAplicacio-form.component';
import { ProjectesAplicacioService } from './projectesAplicacio.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ProjectesAplicacioFormComponent
    ],
	entryComponents: [
		ProjectesAplicacioFormComponent
	],
	exports: [
		ProjectesAplicacioFormComponent
	],
    providers: [
        ProjectesAplicacioService
    ]
} )
export class ProjectesAplicacioFormModule {}