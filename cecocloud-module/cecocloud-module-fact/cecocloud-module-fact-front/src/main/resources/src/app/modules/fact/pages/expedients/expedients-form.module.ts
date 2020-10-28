import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { ExpedientsFormComponent } from './expedients-form.component';
import { ExpedientsService } from './expedients.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        ExpedientsFormComponent
    ],
	entryComponents: [
		ExpedientsFormComponent
	],
	exports: [
		ExpedientsFormComponent
	],
    providers: [
        ExpedientsService
    ]
} )
export class ExpedientsFormModule {}