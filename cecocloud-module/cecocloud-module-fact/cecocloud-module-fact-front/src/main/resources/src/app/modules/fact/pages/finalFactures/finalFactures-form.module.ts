import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { FinalFacturesFormComponent } from './finalFactures-form.component';
import { FinalFacturesService } from './finalFactures.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        FinalFacturesFormComponent
    ],
	entryComponents: [
		FinalFacturesFormComponent
	],
	exports: [
		FinalFacturesFormComponent
	],
    providers: [
        FinalFacturesService
    ]
} )
export class FinalFacturesFormModule {}