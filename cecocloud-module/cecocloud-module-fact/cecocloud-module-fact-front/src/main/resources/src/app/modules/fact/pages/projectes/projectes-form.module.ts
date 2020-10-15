import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';
import { TranslateModule } from '@ngx-translate/core';

import { ProjectesFormComponent } from './projectes-form.component';
import { ProjectesService } from './projectes.service';

// Per poder recuperar l'empresa de la sessió:
import { BngAuthService } from 'base-angular';
import { EmpresesService } from '../../../../pages/empreses/empreses.service';
import { EmpresesFactService } from '../empresesFact/empresesFact.service';
import { DivisesService } from '../divises/divises.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule,
		MaterialModule,
		TranslateModule
    ],
    declarations: [
        ProjectesFormComponent
    ],
	entryComponents: [
		ProjectesFormComponent
	],
	exports: [
		ProjectesFormComponent
	],
    providers: [
        ProjectesService,
		BngAuthService,
		EmpresesService,
		EmpresesFactService,
		DivisesService
    ]
} )
export class ProjectesFormModule {}