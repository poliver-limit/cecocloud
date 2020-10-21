import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { AvariesFormComponent } from './avaries-form.component';
import { AvariesService } from './avaries.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule
    ],
    declarations: [
        AvariesFormComponent
    ],
	entryComponents: [
		AvariesFormComponent
	],
	exports: [
		AvariesFormComponent
	],
    providers: [
        AvariesService
    ]
} )
export class AvariesFormModule {}